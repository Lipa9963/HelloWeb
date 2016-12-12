/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function on_load(){
    document.getElementById("output").style.textAlign = "center";
}

function validate_form() {
    var x = document.getElementById("output").value;
    if (x === null || x === "") {
        alert("Name must be filled out");
        on_load();
        return false;
        
    }
}

function reply_click(clicked_id) {
    switch(clicked_id) {
    case "minus":
        clicked_id ="-";
        break;
    case "plus":
        clicked_id ="+";
        break;
    case "division":
        clicked_id ="/";
        break;
    case "expo":
        clicked_id ="^";
        break;
    case "mul":
        clicked_id ="*";
        break;
    case "largebracketl":
        clicked_id ="]";
        break;
    case "largebracketr":
        clicked_id ="[";
        break;
    case "or":
        clicked_id ="|";
        break;
    case "righbracket":
        clicked_id ="(";
        break;
    case "leftbracket":
        clicked_id =")";
        break;
    case "percent":
        clicked_id ="%";
        break;
    case "point":
        clicked_id =".";
        break;
    case "abc":
        clicked_id ="";
        break;
    case "equal":
        clicked_id ="";
        break;
          
    default:
       
}
    
    var mytextvalue = document.getElementById("output").value; 
      document.getElementById("output").value=mytextvalue +clicked_id ;
}



function input_click_event(){
  document.getElementById("output").style.textAlign = "left";                                                                                                                                                                                     
}

