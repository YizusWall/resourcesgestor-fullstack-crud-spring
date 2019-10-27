
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$(document).ready(function() {

    // Create or update the todo localStorage entry
    if (localStorage.getItem("items")) {
        generateJsonToTable("example");
    } else {

// jQuery preflight request
        $.ajax({
            type: "GET",
            headers: {"Access-Control-Allow-Origin": "*"},
            url: "http://localhost:9090/procesocosto"
        }).done(function (data) {
            console.log(data);
        });
    }

    $(".close").click(function() {
        $("#myAlert").alert("close");
    });
});

function generateJsonToTable(idtable) {
    var colorimg;

    $("#" + idtable)
        .dataTable()
        .fnDestroy();
    $("#" + idtable).dataTable({
        ajax: function(data, callback, settings) {
            callback(JSON.parse(localStorage.getItem("items")));
        },
        aoColumnDefs: [
            {
                aTargets: [5],
                mData: null,
                mRender: function(data, type, full) {
                    colorimg = this.getStatusActivity(data[4]);
                    return (
                        "<img class='rounded-circle' alt='10x10' src='http://the21servicesexportteam.com/cdn/yizuslabs-costmanagement/img/" +
                        colorimg +
                        "_small.jpg' data-holder-rendered='true'>"
                    );
                }
            },
            {
                aTargets: [6],
                mData: null,
                mRender: function(data, type, full) {
                    return "<a href='#' class='Editar'><i class='material-icons' data-toggle='tooltip' title='Editar'>&#xE254;</i></a><a href='#' class='Eliminar'><i class='material-icons' data-toggle='tooltip' title='Eliminar'>&#xE872;</i></a>";
                }
            }
        ]
    });
}

//guardar
/*$("form").submit(function() {

  event.preventDefault();
  var myData = $("form").serializeObject();
  var jsondata=JSON.stringify(myData);
  console.log("json "+jsondata);
    // Create or update the todo localStorage entry
  if (localStorage.getItem("items")) {
    generateJsonToTable("example");
  } else {

  }

  fire_post_submit(jsondata);
  // fire_ajax_submit(jsondata);
  var jsonData = localStorage.getItem("items");

  var obj = JSON.parse(jsonData);
  var dato1 = $("#codbusiness option:selected").text();
  var dato2 = $("#codactivity").val();
  var dato3 = $("#monactivity").val();

  var entry = [dato1, dato2, dato3, 0, 0, "blue"];
  obj["data"].push(entry);
  localStorage.setItem("items", JSON.stringify(obj));

  generateJsonToTable("example");
  $("#myAlert").show();

  $("#myAlert").fadeIn();

  $("#myAlert").slideDown();
  return false;
});*/


function fire_post_submit(jsondata){

    $.post("http://192.168.99.100:32768/unidadnegocio", jsondata, function (data) {
        //  $.post("http://192.168.99.100:9090/unidadnegocio", myData, function (data) {
        console.log(data.name);
    },'json');
}

function fire_ajax_submit(jsondata) {

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://192.168.99.100:32768/unidadnegocio",
        data: jsondata,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}

function getStatusActivity(numporc) {
    var statcolor = "blue";
    if (numporc > 0.5 && numporc <= 0.75) {
        statcolor = "green";
    } else if (numporc > 0.75 && numporc <= 0.9) {
        statcolor = "pink";
    } else if (numporc > 0.9) {
        statcolor = "red";
    }
    return statcolor;
}