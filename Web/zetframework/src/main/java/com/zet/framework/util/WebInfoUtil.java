package com.zet.framework.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author manle
 * 
 */
public class WebInfoUtil {

	private static final String IPADDRESS_PATTERN = 
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	
    private static final String SESS_ACCESS_PAGE = "access_page";

    public static Cookie buildNewCookie(String key, String value, String... path) {

        Cookie cookie = new Cookie(key, value);
        if (path.length > 0)
            cookie.setPath(path[0]);
        else
            cookie.setPath("/");
        return cookie;
    }

    /**
     * Get value of cookie
     * @param cookies
     * @param value
     * @return
     */
    public static String getCookie(Cookie[] cookies, String value) {

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(value)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    
    /**
     * Get key and value cookie
     * @param cookies
     * @param value
     * @return
     */
    public static String[] getCookiesByIp(Cookie[] cookies) {
    	String[] results = new String[2];
    	
    	Pattern pattern= Pattern.compile(IPADDRESS_PATTERN);
    	
        if (null != cookies) {
            for (Cookie cookie : cookies) {
            	Matcher matcher =pattern.matcher(cookie.getName());
                if (matcher.matches()) {
                	results[0]=cookie.getName();
                	results[1]=cookie.getValue();
                	break;
                }
            }
        }
        return results;
    }

    /**
     * 
     * @param cookies
     * @param res
     * @param cookieName
     *            remove specific cookie name
     */
    public static void cleanCookies(Cookie[] cookies, HttpServletResponse res, String[] cookieName) {

        if (null != cookies) {

            boolean removeWithName = false;
            if (cookieName != null && cookieName.length > 0) {
                removeWithName = true;
            }

            for (Cookie cookie : cookies) {

                if (!removeWithName) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    res.addCookie(cookie);
                } else {
                    if (Arrays.asList(cookieName).contains(cookie.getName())) {
                        cookie.setValue(null);
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        res.addCookie(cookie);
                    }
                }

            }
        }
    }

    public static String buildURLPage(final HttpServletRequest request, final String page) {

        String result = "";
        String continueLink = request.getParameter("continue");
        if (StringUtils.isNotBlank(continueLink)) {
            result = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 || request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                    + request.getContextPath() + continueLink;
        } else if (StringUtils.isNotBlank(page)) {
            result = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 || request.getServerPort() == 443 ? "" : ":" + request.getServerPort())
                    + request.getContextPath() + page;
        }
        return result;
    }

    /**
     * The page only allow access when session SESS_ACCESS_PAGE is exist, if not, user cannot access the pageUri
     * 
     * @param session
     * @param pageUri
     * @return
     */
    public static String accessPage(HttpServletRequest request, HttpSession session, String pageUri, boolean... isFoward) {

        session.setAttribute(SESS_ACCESS_PAGE, SESS_ACCESS_PAGE);
        String pageUrl = buildURLPage(request, pageUri);
        if (isFoward.length > 0 && !isFoward[0])
            return "redirect:" + pageUrl;
        else
            return "forward:" + pageUri;
    }

    /**
     * Remove session SESS_ACCESS_PAGE and redirect to pageUri
     * 
     * @param session
     * @param pageUri
     *            link notice
     * @param pageUriDefault
     *            link login
     * @return
     */
    public static String unAccessPage(HttpServletRequest request, HttpSession session, String pageUriTiles, String pageUriDefaultTiles) {

        if (session.getAttribute(SESS_ACCESS_PAGE) == null) {
            return "redirect:" + buildURLPage(request, pageUriDefaultTiles);
        }
        session.setAttribute(SESS_ACCESS_PAGE, null);
        return pageUriTiles;
    }
}
