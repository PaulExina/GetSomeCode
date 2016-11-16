var tags = [];
var tags_search = [];

/*Tags Handler*/

function addTag(){
    
    
    document.getElementById("tags").innerHTML = document.getElementById("tags").innerHTML + "     <span class='label label-primary'>"+document.getElementById("snippet_tags").value+"</span>    ";
    alert( document.getElementById("tags").innerHTML);
    tags.push(document.getElementById("snippet_tags").value.toLowerCase());
}

function addTagSearch(){
    document.getElementById("tags_search").innerHTML = document.getElementById("tags_search").innerHTML + "     <span class='label label-primary'>"+document.getElementById("snippet_tags_search").value+"</span>    ";
  
    tags_search.push(document.getElementById("snippet_tags_search").value.toLowerCase());
}

function removeTag(){
    var child = document.getElementById("tags").lastChild;
    document.getElementById("tags").removeChild(child); 
    tags.splice(tags.length-1, tags.length);
}

function removeTagSearch(){
    var child = document.getElementById("tags_search").lastChild;
    document.getElementById("tags_search").removeChild(child); 
    tags_search.splice(tags_search.length-1, tags_search.length);
}

/**Post Snippets*/

function postSnippet(){
    
    var snippet_title = document.getElementById("snippet_title").value;
    
    var lang = document.getElementById("button_language").name;

    var cat = document.getElementById("button_category").name;
        
    var snippet_tags = tags;
    
    var snippet_description = document.getElementById("snippet_description").value;
    
    var snippet_content = document.getElementById("snippet_content").value;
    
    var snippet = {
        
        author : snippet_author,
        title : snippet_title,
        id_l : lang,
        id_c : cat,
        tags : snippet_tags,
        description : snippet_description,
        content : snippet_content
    }
    
    

    endPost();
}

function endPost(){
    document.getElementById("snippet_title").value="";
    document.getElementById("button_language").innerHTML = "Choose a language <span class='caret'></span>";
    document.getElementById("button_language").name = "";
    document.getElementById("button_category").innerHTML = "Choose a category <span class='caret'></span>";    
    document.getElementById("button_category").name = "";   
    document.getElementById("snippet_tags").value="";
    document.getElementById("tags").innerHTML="";           
    document.getElementById("snippet_description").value="";
    document.getElementById("snippet_content").value="";
    tags = [];                                                                                                                                                            
}

/**Search Snippets*/

function searchSnippet(){
    
    var snippet_title = document.getElementById("snippet_search").value; 
    
    var snippet_author = document.getElementById("snippet_author").value;
    
    var snippet_language = document.getElementById("button_language_search").name;
    
    var snippet_category = document.getElementById("button_category_search").name;
    
    var snippet_tags = tags_search;
    
    var search = {
        title : snippet_title,
        author : snippet_author,
        language : snippet_language,
        category : snippet_category,
        tags : tags_search
    }

    endSearch();
}

function endSearch(){
    document.getElementById("snippet_search").value="";
    document.getElementById("snippet_author").value="";
    document.getElementById("button_language_search").innerHTML = "Choose a language <span class='caret'></span>";
    document.getElementById("button_language_search").name = "";
    document.getElementById("button_category_search").innerHTML = "Choose a category <span class='caret'></span>";    
    document.getElementById("button_category_search").name = "";   
    document.getElementById("snippet_tags_search").value="";
    document.getElementById("tags_search").innerHTML="";           
    tags_search = [];                                                                                                                                                            
}






