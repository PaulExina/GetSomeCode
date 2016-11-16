window.onresize = function(){

    var w = window.innerWidth
    || document.documentElement.clientWidth
    || document.body.clientWidth;

    var h = window.innerHeight
    || document.documentElement.clientHeight
    || document.body.clientHeight;

    if ( w < 770 ){
        document.getElementById("snippet_search").style.width="100%";
        document.getElementById("snippet_title").style.width="100%";
        document.getElementById("snippet_content").style.width="100%";
        document.getElementById("snippet_description").style.width="100%";
    }
    else{
        document.getElementById("snippet_search").style.width="169%";
        document.getElementById("snippet_title").style.width="150%";
        document.getElementById("snippet_content").style.width="150%";
        document.getElementById("snippet_description").style.width="150%";
    }

}

window.onload = function(){

    var w = window.innerWidth
    || document.documentElement.clientWidth
    || document.body.clientWidth;

   

    if ( w < 770 ){
        document.getElementById("snippet_search").style.width="100%";
        document.getElementById("snippet_title").style.width="100%";
        document.getElementById("snippet_content").style.width="100%";
        document.getElementById("snippet_description").style.width="100%";
    }
    else{
        document.getElementById("snippet_search").style.width="169%";
        document.getElementById("snippet_title").style.width="150%";
        document.getElementById("snippet_content").style.width="150%";
        document.getElementById("snippet_description").style.width="150%";
    }
    

}


