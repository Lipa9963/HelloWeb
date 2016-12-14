/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var is_add_square = null;
var is_add_operator = null;
var cant = "a1";
var savedrange = null;
var MathJaxElementScriptCount =0;
var MathJaxElementFrameCount=0; 

function on_load() {
   //  document.getElementById("inputDiv").style.textAlign = "center";
  
   
    $(function() {
   $('#inputDiv').focus();
});
}


  

function validate_form() {
    var x = document.getElementById("output").value;
    if (x === null || x === "") {
        alert("Name must be filled out");
        on_load();
        return false;

    }
}



$(document).ready(function(){
   $('#inputDiv').bind("keydown", function(event) {
      //event.preventDefault();
     // replyClickMath(event.keyCode);
    //console.log(event.keyCode);
    switch(event.keyCode){
       //....your actions for the keys .....
    }
 }); 
});





function insertMathField (expression){
       
    var MQ = MathQuill.getInterface(2);
    var answerSpan = document.getElementById('inputDiv');
     var mathField = MQ.MathField(answerSpan);   
 
    //  mathField.typedText(expression);
     mathField.write(expression);
     mathField.focus();
}

function runMathJax(id){
    
    
         MathJax.Hub.Config({
        showMathMenu: false,
        "HTML-CSS": {display: "black", contenteditable: "false", scale: 100, linebreaks: {automatic: false}},
        SVG: {linebreaks: {automatic: false}},
        displayAlign: "left"});
        
         
    
    MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
  
   
  
    
}
function getCaret(el) {
    if (el.selectionStart) {
        return el.selectionStart;
    } else if (document.selection) {
        el.focus();

        var r = document.selection.createRange();
        if (r == null) {
            return 0;
        }

        var re = el.createTextRange(),
                rc = re.duplicate();
        re.moveToBookmark(r.getBookmark());
        rc.setEndPoint('EndToStart', re);

        return rc.text.length;
    }
    return 0;
 }    

    
    function KeyPress(e) {

        var keynum;
        alert("sffs");
        if (window.event) { // IE                    
            keynum = e.keyCode;
        } else if (e.which) { // Netscape/Firefox/Opera                   
            keynum = e.which;
        }

        //alert(String.fromCharCode(keynum));

    }





 function input_click_event() {
        var x = document.getElementById("inputDiv").innerHTML;
        alert(x.toString());
        if (x.toString() === "הקלד כאן את התרגיל")
        {
            document.getElementById("output").value = "";
            document.getElementById("output").style.textAlign = "left";
        }

    }

function reset(){
     $("#divAfterSubmit").hide();
     $("#clcultor").show();
     var elem = document.getElementById("output");
     elem.focus();
     
}

function test(){
    var math ="`square(22+88)`";

//
//     document.getElementById('inputDiv').style.textAlign="left";
//     document.getElementById('inputDiv').focus();
//      pasteHtmlAtCaret(math);
//      sleep(2);
//     MathJax.Hub.Config({ 
//        "HTML-CSS": {display:"inline",contenteditable:"false", scale: 100, linebreaks: { automatic: false } }, 
//        SVG: { linebreaks: { automatic:false } }, 
//        displayAlign: "left" });
//    
//  
//
//   
//        runMathJax("inputDiv");

var MQ = MathQuill.getInterface(2);
var answerSpan = document.getElementById('inputDiv');
 var mathField = MQ.MathField(answerSpan);   
 //mathField.write('\\sqrt[]{}');
 mathField.cmd('\\sqrt');
//mathField.typedText("\\frac");

 
}


function test1(){
    var s1 = "<math display='block'><mrow><msqrt><mrow><mn>22</mn><msqrt><mrow><mn>11</mn></mrow></msqrt></mrow></msqrt></mrow></math>";
    var s3 = "\\[\\sqrt {{a^2} + {b^2}} \\]";
  
    document.getElementById("inputDiv").innerHTML=s3;
    
         MathJax.Hub.Config({ 
           showMathMenu: false,    
       "HTML-CSS": {display:"inline",contenteditable:"false", scale: 100, linebreaks: { automatic: false }   }, 
        SVG: { linebreaks: { automatic:false } }, 
        displayAlign: "left" });
    runMathJax("inputDiv");
         
    

//   var elem= document.getElementById("inputDiv");
//   setEndOfContenteditable(elem);
   
    //setCursorToEnd( document.getElementById("inputDiv"));
//   var script =  GetElementInsideContainer("inputDiv","MathJax-Element-1");
//    alert(script.innerHTML);
//   

  // use the native .trim() if it exists
  //   otherwise use a regular expression  
//    if ($('#inputDiv').is(':empty')){
//         alert("emp");
  //do something
//}

  
    
   
   
}

function pasteHtmlAtCaret(html) {
   
    var sel, range;
     
     
    if (window.getSelection) {
        // IE9 and non-IE
        
        sel = window.getSelection();
        
       if (sel.getRangeAt && sel.rangeCount) {
            range = sel.getRangeAt(0);
            range.deleteContents();
            
            
            // Range.createContextualFragment() would be useful here but is
            // non-standard and not supported in all browsers (IE9, for one)
            var el = document.createElement("div");
            el.innerHTML = html;
            var frag = document.createDocumentFragment(), node, lastNode;
            while ( (node = el.firstChild) ) {
                   lastNode = frag.appendChild(node);
            }
            range.insertNode(frag);
            
            // Preserve the selection
            if (lastNode) {
                
                range = range.cloneRange();
                alert(range);
                range.setStartAfter(lastNode);
                range.collapse(true);
                sel.removeAllRanges();
                sel.addRange(range);
            }
        }
    } else if (document.selection && document.selection.type !== "Control") {
        // IE < 9
        
        document.selection.createRange().pasteHTML(html);
    }
}
function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}


function getCaretCharacterOffsetWithin(element) {
    var caretOffset = 0;
    if (typeof window.getSelection !== "undefined") {
        var range = window.getSelection().getRangeAt(0);
        var preCaretRange = range.cloneRange();
        preCaretRange.selectNodeContents(element);
        preCaretRange.setEnd(range.endContainer, range.endOffset);
        caretOffset = preCaretRange.toString().length;
    } else if (typeof document.selection !== "undefined" && document.selection.type !== "Control") {
        var textRange = document.selection.createRange();
        var preCaretTextRange = document.body.createTextRange();
        preCaretTextRange.moveToElementText(element);
        preCaretTextRange.setEndPoint("EndToEnd", textRange);
        caretOffset = preCaretTextRange.text.length;
    }
    return caretOffset;
}

function showCaretPos() {
    var el = document.getElementById("inputDiv");
     return  getCaretCharacterOffsetWithin(el);
}
   
   
   
   
   

function GetElementInsideContainer(containerID, childID) {
    var elm = document.getElementById(childID);
    var parent = elm ? elm.parentNode : {};
    return (parent.id && parent.id === containerID) ? elm : {};
}


function getCharacterOffsetWithin(range, node) {
    var treeWalker = document.createTreeWalker(
        node,
        NodeFilter.SHOW_TEXT,
        function(node) {
            var nodeRange = document.createRange();
            nodeRange.selectNode(node);
            return nodeRange.compareBoundaryPoints(Range.END_TO_END, range) < 1 ?
                NodeFilter.FILTER_ACCEPT : NodeFilter.FILTER_REJECT;
        },
        false
    );

    var charCount = 0;
    while (treeWalker.nextNode()) {
        charCount += treeWalker.currentNode.length;
    }
    if (range.startContainer.nodeType == 3) {
        charCount += range.startOffset;
    }
    return charCount;
}

window.onload=function(){
    runMathJax();
    
    var MQ = MathQuill.getInterface(2);
  var answerSpan = document.getElementById('inputDiv');
  
  var answerMathField = MQ.MathField(answerSpan, {
    handlers: {
      edit: function() {
        var enteredMath = answerMathField.latex(); // Get entered math in LaTeX format
		//alert(answerMathField.latex());
               
        //checkAnswer(enteredMath);
        
      }
    }
  });
  
     var answerSpan = document.getElementById('inputDiv');
     var mathField = MQ.MathField(answerSpan);   
 
    //  mathField.typedText(expression);
     
     mathField.focus();
  
    //var mb = document.getElementById("div1");
    //mb.addEventListener("keydown", tt);
    //mb.addEventListener("click", handler2);
}




function addClick(newExpression){
    
    if ($('#inputDiv').is(':empty')){
            var output = addBracketsLatex(newExpression);
            insertLatexTOdiv(output);
            setTimeout("setMouse()",500);
            return; 
        }
    
  //  var el = document.getElementById("inputDiv");
  //  var range = window.getSelection().getRangeAt(0);
   // var position = getCharacterOffsetWithin(range, el);
    var position = reportSelection();
    //alert(position);
    var script =  GetElementInsideContainer("inputDiv","MathJax-Element-"+MathJaxElementScriptCount);
  //  alert(script.innerHTML);
    
    
    insertSubString(script.innerHTML,newExpression,position);
 
    setTimeout("setMouse()",200);

}



function setMouse(){
    
    
    var urlDiv = "MathJax-Element-"+MathJaxElementFrameCount+"-Frame";
    var elem = document.getElementById(urlDiv);
    document.getElementById(urlDiv).focus();
    setEndOfContenteditable(elem);
     document.getElementById("inputDiv").focus();
}


function insertSubString(main,sub,position){
	
        alert(" main: " + main +" sub: "+sub + " position: " + position);
	 var count = 0; 
         var input = [];
         var lock =0;
	
         //main = main.replace(/\s+/, "");
                
                
                
        if(position === 0){
            var output = main.substr(0, position) + sub + main.substr(position);
            output = addBracketsLatex(output);
            insertLatexTOdiv(output);
            return; 
         }  
         
         
                
                for (var i = 0, len = main.length; i < len; i++)
		 {
                      //  alert(" main[i]: " + main[i] + " i: " + i);                     
			 var str = main[i];
         			 
			 switch(str){
				 
				 case "\\":
				 if(main[i+1]==="s"){
                                     input.push("\\sqrt"); i=i+4;
                                 }else if(main[i+1]==="f"){
                                     input.push("\\frac"); i=i+4;
                                     
                                     
                                 }
                                 break;
                                 
                                 			 
				 				 			 
				 case "0":
				 case "1":
				 case "2":
				 case "3":
				 case "4":
				 case "5":
				 case "6":
				 case "7":
				 case "8":
				 case "9":
				 case "+":
				 case "-":
				 case "*":
				 case "/":
                                 case "^":
                                 case "?":    
                                 input.push(str);     
				 count++;
				 break;
                                 case "{":
                                 case "}":
                                 input.push(str);    
                                 break;    
				 
			 }
               //          alert(input.toString());
			  
                         
			  //alert("position: " +position+" count: "+ count);
			  if(position === count && lock === 0){
				  // var output = main.substr(0, position) + sub + main.substr(position);
                                 //alert("output :" +output.toLocaleString());
                                  lock=1;
                                  
                                  input.push(sub);
                                  
                                                                                                    
			  }
			  
             
		 }
              
             //alert(input.toString());
           //  input=input.join("");
            input=input.join(' ');
            
            output = addBracketsLatex(input);
            insertLatexTOdiv(output);
             
	
}

function isCharDigit(n){
  return !!n.trim() && !isNaN(+n);
}


function addBracketsLatex(outout){
    var first ="\\[";
    var last = first.concat(outout);
    first ="\\]";
    return last.concat(first);
}

function insertLatexTOdiv(str){
    $('#inputDiv').html('');
    document.getElementById("inputDiv").innerHTML=str;
    runMathJax("inputDiv");
    
    
}



 $(document).on("click", "#submit", function () {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                 var MQ = MathQuill.getInterface(2);
                 var answerSpan = document.getElementById('inputDiv');
                 var answerMathField = MQ.MathField(answerSpan);
                 
                 var output = answerMathField.latex();
                $.ajax({
                    type: 'POST',
                    url: 'Servlet',
                    data:{name:output},
                    dataType: "json",
                    success: function (data) {
                        if (data) {
                            
                            //$("#table td").remove();
                            $(document).ready(function() {
                                $("#tableRe").find("tr:gt(0)").remove();
                            });
                            
                            var len = data.list.length;
                            
                            var txt = "";
                            
                            if (len > 0) {
                                for (var i = 0; i < len; i++) {
                                                                                                                     
                                        txt += "<tr>"
                                                + "<td>" + data.list[i].infixBefore + "</td>" 
                                                + "</tr>";
                                    
                                }
                                 txt += "<tr>"
                                                + "<td>" + data.list[i-1].infixAfter + "</td>" 
                                                + "</tr>";
                                    
                                if (txt !== "") {
                                    
                                    $("#alcultor").hide();
                                    $("#table").show();
                                    $("#table").append(txt);
                                    runMathJax();
                                }
                            }

                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert('error: ' + textStatus + ': ' + errorThrown);
                    }
                });
                
            });