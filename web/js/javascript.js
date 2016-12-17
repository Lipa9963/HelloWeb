/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var is_add_square = null;
var is_add_operator = null;
var cant = "a1";
var savedrange = null;
var MathJaxElementScriptCount = 0;
var MathJaxElementFrameCount = 0;
var RaundSrepCount = 0;

function on_load() {
    //  document.getElementById("inputDiv").style.textAlign = "center";


    $(function () {
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



$(document).ready(function () {
    $('#inputDiv').bind("keydown", function (event) {
        //event.preventDefault();
        // replyClickMath(event.keyCode);
        //console.log(event.keyCode);
        switch (event.keyCode) {
            //....your actions for the keys .....
        }
    });
});





function insertMathField(expression) {

    var MQ = MathQuill.getInterface(2);
    var answerSpan = document.getElementById('inputDiv');
    var mathField = MQ.MathField(answerSpan);

    //  mathField.typedText(expression);
    mathField.write(expression);
    mathField.focus();
}

function runMathJax(id) {


    MathJax.Hub.Config({
        showMathMenu: false,
        "HTML-CSS": {display: "black", contenteditable: "false", scale: 100, linebreaks: {automatic: false}},
        SVG: {linebreaks: {automatic: false}},
        displayAlign: "left"});



    MathJax.Hub.Queue(["Typeset", MathJax.Hub]);




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

function reset() {
    $("#divAfterSubmit").hide();
    $("#clcultor").show();
    var elem = document.getElementById("output");
    elem.focus();

}

function test() {
    var math = "`square(22+88)`";

    var obj2 = JSON.parse(localStorage.getItem('myObj'));
    var len = obj2.answerLists[0].list.length;
    alert(len);

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

//var MQ = MathQuill.getInterface(2);
//var answerSpan = document.getElementById('inputDiv');
// var mathField = MQ.MathField(answerSpan);   
// //mathField.write('\\sqrt[]{}');
// mathField.cmd('\\sqrt');
//mathField.typedText("\\frac");


}





function sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
        if ((new Date().getTime() - start) > milliseconds) {
            break;
        }
    }
}




window.onload = function () {
    runMathJax();

    var MQ = MathQuill.getInterface(2);
    var answerSpan = document.getElementById('inputDiv');

    var answerMathField = MQ.MathField(answerSpan, {
        handlers: {
            edit: function () {
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




function addClick(newExpression) {

    if ($('#inputDiv').is(':empty')) {
        var output = addBracketsLatex(newExpression);
        insertLatexTOdiv(output);
        setTimeout("setMouse()", 500);
        return;
    }

    //  var el = document.getElementById("inputDiv");
    //  var range = window.getSelection().getRangeAt(0);
    // var position = getCharacterOffsetWithin(range, el);
    var position = reportSelection();
    //alert(position);
    var script = GetElementInsideContainer("inputDiv", "MathJax-Element-" + MathJaxElementScriptCount);
    //  alert(script.innerHTML);


    insertSubString(script.innerHTML, newExpression, position);

    setTimeout("setMouse()", 200);

}



function setMouse() {


    var urlDiv = "MathJax-Element-" + MathJaxElementFrameCount + "-Frame";
    var elem = document.getElementById(urlDiv);
    document.getElementById(urlDiv).focus();
    setEndOfContenteditable(elem);
    document.getElementById("inputDiv").focus();
}



function isCharDigit(n) {
    return !!n.trim() && !isNaN(+n);
}


function addBracketsLatex(outout) {
    var first = "\\[";
    var last = first.concat(outout);
    first = "\\]";
    return last.concat(first);
}


function addRoundStep() {

    var data = JSON.parse(localStorage.getItem('myObj'));
    var len = data.answerLists[RaundSrepCount].list.length;
    var txt = "";
    
     
    if (len > 0) {
        for (var i = 0; i < len; i++) {

            txt += "<tr>"
                    + "<td>" + data.answerLists[RaundSrepCount].list[i].infixBefore + "</td>"
                    + "</tr>";

        }
        txt += "<tr>"
                + "<td>" + data.answerLists[RaundSrepCount].list[i - 1].infixAfter + "</td>"
                + "</tr>";

        if (txt !== "") {

            $("#alcultor").hide();
            $("#table").show();
            $("#table").append(txt);
            runMathJax();
            RaundSrepCount = RaundSrepCount+1;
        }
    }

   
}


$(document).on("click", "#submit", function () {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    var MQ = MathQuill.getInterface(2);
    var answerSpan = document.getElementById('inputDiv');
    var answerMathField = MQ.MathField(answerSpan);

    var output = answerMathField.latex();
    $.ajax({
        type: 'POST',
        url: 'Servlet',
        data: {name: output},
        dataType: "json",
        success: function (data) {
            if (data) {

                //$("#table td").remove();
                $(document).ready(function () {
                    $("#tableRe").find("tr:gt(0)").remove();
                });

                localStorage.setItem('myObj', JSON.stringify(data));
                var len = data.answerLists[0].list.length;
                RaundSrepCount = RaundSrepCount+1; 
                
                var txt = "";
 
                if (len > 0) {
                    for (var i = 0; i < len; i++) {

                        txt += "<tr>"
                                + "<td>" + data.answerLists[0].list[i].infixBefore + "</td>"
                                + "</tr>";

                    }
                    txt += "<tr>"
                            + "<td>" + data.answerLists[0].list[i - 1].infixAfter + "</td>"
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