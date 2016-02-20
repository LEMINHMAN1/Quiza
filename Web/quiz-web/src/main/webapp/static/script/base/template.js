var loginLink = "http://localhost:4567/login.htm";


function statusChangeCallback(response) {
   if (response.status === 'connected') {
	   initValue();
    } else {
    	// Redirect to Login Page, this bellow is example
    	//window.location.assign(loginLink);
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '995877583808931',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.4' // use version 2.4
  });

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  
  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function initValue() {
    FB.api('/me?fields=link,email,picture,name', function(response) {
      $('#myprofile_avatar').attr('src',response.picture.data.url);
      $('#myprofile_name').html(response.name);
      $('#myprofile_name').attr('href',response.link);
      $('#myprofile_email').html(response.email);
      
      
      var json = { name : response.name, email : response.email};
	   $.ajax({
		   	headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    type:"post",
		    data:JSON.stringify(json),
		    url:"/login.htm",
		    dataType: "json",
		    success: function(data){
		    	alert(data.success);
		    }

		});
      
      
    });
  }
  
  
  
  
  
  
  
  
  
  
  
$(function(){
	$('#template_Logout').click(function(){
		FB.logout(function(response) {
			window.location.assign(loginLink);
		});
	});
})  
  