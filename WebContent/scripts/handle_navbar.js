
function page_post(){
    document.getElementById("page_title").innerHTML = "Post your snippets...";
    document.getElementById("page_purpose").innerHTML= "In here, you can post any snippets of code you want by indexing its language, category or else...";
    document.getElementById("container_post_snippet").style.display = "block";
    document.getElementById("container_search_snippet").style.display = "none";
    document.getElementById("container_edit_snippet").style.display = "none";
    
    document.getElementById("html").style.height ="auto";
    
}

function page_search(){
    document.getElementById("page_title").innerHTML = "Search for snippets...";
    document.getElementById("page_purpose").innerHTML= "In here, you can search the snippets you need using the category, tags, language or else... ";
    document.getElementById("container_post_snippet").style.display = "none";
    document.getElementById("container_edit_snippet").style.display = "none";
    document.getElementById("container_search_snippet").style.display = "block";
  
    document.getElementById("html").style.height = "100%";
   
}

function page_edit(){
    document.getElementById("page_title").innerHTML = "Edit your code...";
    document.getElementById("page_purpose").innerHTML= "In here, you can edit your code by loading your files...";
    document.getElementById("container_edit_snippet").style.display = "block";
    document.getElementById("container_post_snippet").style.display = "none";
    document.getElementById("container_search_snippet").style.display = "none";
   
    document.getElementById("html").style.height = "100%";
    
}