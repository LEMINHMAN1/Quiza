$(function(){
		
          var txtTest="";
          var txtTestPass="";
         
          var mapUserNameValue={};
          var mapPasswordValue={};
          $('.btnEdit').click(function(){
              
               var idUserName = $(this).attr('unid');
               var idPassword = $(this).attr('pswid');
               var idSubmitButton = $(this).attr('subid');
               var idCancelButton = $(this).attr('canid');
               mapUserNameValue[idUserName] = $('#'+idUserName).val();
               mapPasswordValue[idPassword] = $('#'+idPassword).val();
              
               $('#'+idUserName).removeAttr('disabled').removeAttr('style');
               $('#'+idUserName).addClass('form-control').addClass('input-sm');
              
               $('#'+idPassword).removeAttr('disabled').removeAttr('style');
               $('#'+idPassword).addClass('form-control').addClass('input-sm');
              
               $('#'+idSubmitButton).css({'display':''});
               $('#'+idCancelButton).css({'display':''});
              
               $(this).css({'display':'none'});
               
          });
         
          $('.btnSubmit').click(function(){
        	  
        	  var idUserName = $(this).attr('unid');
              var idPassword = $(this).attr('pswid');
              var idSubmitButton = $(this).attr('subid');
              var idCancelButton = $(this).attr('canid');
              var idEditButton = $(this).attr('eid');
              
        	  $.post( "/p4r/accmanager.htm", {  
        		  								webAccId: $(this).attr('waid'), 
        		  								usn:$('#'+$(this).attr('unid')).val(), 
        		  								pw:$('#'+$(this).attr('pswid')).val(),
        		  								sn:$('#'+$(this).attr('sn')).html(),
        		  								inHTMLUn : $(this).attr('unid'), 
        		  								inHTMLPw : $(this).attr('pswid')
        		  							 }, function( data ) {
        		  $('#accManager_msg').html(data.msg);
        		  
        		  if(data.success){
        			  mapUserNameValue[idUserName] = $('#'+idUserName).val();
                      mapPasswordValue[idPassword] = $('#'+idPassword).val();
                      
                      $('#'+idUserName).val(mapUserNameValue[idUserName]);
                      $('#'+idUserName).attr('disabled','disabled');
                      $('#'+idUserName).css({'border': 'none','background-color':'transparent'});
                      $('#'+idUserName).removeClass('form-control');
                     
                      $('#'+idPassword).val(mapPasswordValue[idPassword]);
                      $('#'+idPassword).attr('disabled','disabled');
                      $('#'+idPassword).css({'border': 'none','background-color':'transparent'});
                      $('#'+idPassword).removeClass('form-control');
                     
                      $('#'+idSubmitButton).css({'display':'none'});
                      $('#'+idCancelButton).css({'display':'none'});
                     
                      $('#'+idEditButton).css({'display':''});
        		  
        		  }else{
        			  for(var i=0 ; i<data.htmlIdsError.length; i++){
        				  $('#'+data.htmlIdsError[i]).css({'border-color': 'red'});
        			  }
        		  }
              
        		});
          });
          
          $('.btnCancel').click(function(){
               var idUserName = $(this).attr('unid');
               var idPassword = $(this).attr('pswid');
               var idSubmitButton = $(this).attr('subid');
               var idCancelButton = $(this).attr('canid');
               var idEditButton = $(this).attr('eid');
              
               $('#'+idUserName).val(mapUserNameValue[idUserName]);
               $('#'+idUserName).attr('disabled','disabled');
               $('#'+idUserName).css({'border': 'none','background-color':'transparent'});
               $('#'+idUserName).removeClass('form-control');
              
               $('#'+idPassword).val(mapPasswordValue[idPassword]);
               $('#'+idPassword).attr('disabled','disabled');
               $('#'+idPassword).css({'border': 'none','background-color':'transparent'});
               $('#'+idPassword).removeClass('form-control');
              
               $('#'+idSubmitButton).css({'display':'none'});
               $('#'+idCancelButton).css({'display':'none'});
              
               $('#'+idEditButton).css({'display':''});
               
               $('#accManager_msg').html('');
              
          });
     });