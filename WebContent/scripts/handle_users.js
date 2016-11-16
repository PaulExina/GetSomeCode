function log_in(){

    var username = document.getElementById("inputLogin").value;
    var password = document.getElementById("inputPwdLogin").value;
    
    var attempt = {
        username : username,
        passwd : password
    }
    
    var success = function(data){
        var user = JSON.parse(data);1  
        document.getElementByClass("nav navbar-nav navbar-right").innerHTML="<li><a href='#' class='navbar_element'>"+Bienvenue,+"<b>"+user.firstname+" "+user.lastname+"</b></a></li>";
    }

    var error = function(err){
        alert("Error in login : "+JSON.stringify(err));
    }

    $.ajax({
        url : "./user/login",
        type: "post",
        data: attempt,      
        dataType: "json", 
        success: success,
        error: error
    });

}


function sign_in(){
    var last_name = document.getElementById("inputLastName").value;
    var first_name = document.getElementById("inputFirstName").value;
    var user_name = document.getElementById("inputUserName").value;
    
    var email = document.getElementById("inputEmail").value;
    var password = document.getElementById("inputPwd").value;
    
    var user = {
        username : user_name,
        firstname : first_name,
        lastname : last_name,
        email : email,
        passwd : password
    }
    
    var success = function(data){
        document.getElementById("loginModal").modal('show');
    }
    
    var error = function(err){
        alert("Error in sign up : "+JSON.stringify(err));
    }
    
    $.ajax({
        url : "./user/add",
        type: "post",
        data: user,    
        dataType: "json", 
        success: success,
        error: error
    });
    
}
