function switch_language(lang,id){
    document.getElementById("button_language").innerHTML= lang+ "  <span class='caret'></span>";    
    document.getElementById("button_language").name = id;
}

function switch_language_search(lang,id){
    document.getElementById("button_language_search").innerHTML= lang+ "  <span class='caret'></span>"; 
    document.getElementById("button_language_search").name = id;
}

function switch_cat(cat,id){
    document.getElementById("button_category").innerHTML= cat+ "  <span class='caret'></span>";
    document.getElementById("button_category").name= id;
}

function switch_cat_search(cat,id){
    document.getElementById("button_category_search").innerHTML= cat+ "  <span class='caret'></span>";   
    document.getElementById("button_category_search").name = id;
}

function getLanguages(){
    
    var language = [
        {id : 4,name : "Java"},
        {id : 1,name : "C"},
        {id : 3,name : "C++"},
        {id : 2,name : "Python"}    
    ];  

    if(document.getElementById("menu_languages").innerHTML === ""){
        //Generer la requete
        for(var i= 0;i<language.length;i++){
                document.getElementById("menu_languages").innerHTML = document.getElementById("menu_languages").innerHTML + "<li><a onclick=\"javascript:switch_language(\'"+language[i].name.toString()+"\',"+language[i].id+")\" name='"+language[i].id+"'>"+language[i].name+"</a></li>";

            }
        
        //Ajouter ce code dans le success
        /*var success= function(data){
           
        }

        var error = function(err){
            alert("Error in get language : "+ JSON.stringify(err));
        }


        $.ajax({
            url : ,
            type: "get",
            data: values,      
            dataType: "json", 
            success: success,
            error: error
        })*/
   }
}

function getSearchLanguages(){

    var language = [
        {id : 4,name : "Java"},
        {id : 1,name : "C"},
        {id : 3,name : "C++"},
        {id : 2,name : "Python"}    
    ];  

    
    if(document.getElementById("search_languages").innerHTML === ""){
        //Generer la requete
        for(var i= 0;i<language.length;i++){
                document.getElementById("search_languages").innerHTML = document.getElementById("search_languages").innerHTML + "<li><a onclick=\"javascript:switch_language_search(\'"+language[i].name.toString()+"\',"+language[i].id+")\" name='"+language[i].id+"'>"+language[i].name+"</a></li>";

            }
        //Ajouter ce code dans le success
       /* var success = function(data){
                    
          
        }
        

        var error = function(err){
            alert("Error in getSearchlanguage : "+ JSON.stringify(err));
        }


        $.ajax({
            url : ,
            type: "get",
            data: values,      
            dataType: "json", 
            success: success,
            error: error
        })*/
    }
}

function getCategories(){

    var categories =  [
        {id : 45,name : "Java"},
        {id : 15,name : "C"},
        {id : 354,name : "C++"},
        {id : 221,name : "Python"}    
    ];  
    //Generer la requete
    if(document.getElementById("menu_categories").innerHTML === ""){
    //Ajouter ce code dans le success
        for(var i= 0;i<categories.length;i++){
                document.getElementById("menu_categories").innerHTML = document.getElementById("menu_categories").innerHTML + "<li><a onclick=\"javascript:switch_cat(\'"+categories[i].name+"\',"+categories[i].id+")\" name='"+categories[i].id+"'>"+categories[i].name+"</a></li>";
            }
        
        /*var success = function(data){
            
        }


        var error = function(err){
            alert("Error in get categories : "+ JSON.stringify(err));
        }


        $.ajax({
            url : ,
            type: "get",
            data: values,      
            dataType: "json", 
            success: success,
            error: error
        })*/
    
    }

}

function getSearchCategories(){

    var categories =  [
        {id : 45,name : "Java"},
        {id : 15,name : "C"},
        {id : 354,name : "C++"},
        {id : 221,name : "Python"}    
    ];  
    //Generer la requete
    if(document.getElementById("search_categories").innerHTML === ""){
        //Ajouter ce code dans le success
        for(var i= 0;i<categories.length;i++){
                document.getElementById("search_categories").innerHTML = document.getElementById("search_categories").innerHTML + "<li><a onclick=\"javascript:switch_cat_search(\'"+categories[i].name+"\',"+categories[i].id+")\" name='"+categories[i].id+"'>"+categories[i].name+"</a></li>";
            }
        
        /*
        var success= function(data){
          
        }


        var error = function(err){
            alert("Error in get Search Categories : "+ JSON.stringify(err));
        }


        $.ajax({
            url : ,
            type: "get",
            data: values,      
            dataType: "json", 
            success: success,
            error: error
        });*/
    }
}