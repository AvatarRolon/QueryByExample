$(document).ready(function (){
    $("#btnTables").click(function(){
        var formTables = $("#formTables").serialize();
        
        var resultTables = $("#resultTables");
        
        $.ajax({
            url: "../../selectTablesDB",
            data: formTables,
            success: function(result){
                resultTables.empty();
                $('#myModal').modal('hide')
                resultTables.html("<br><div class='span12'>"+result+"</div>");
            }
        });        
    });         
    
    $("#execute").click(function(){
        var formExecute = $("#formExec").serialize();
        
        var resultExec = $("#resultExec");
        
        
        $.ajax({
            url: "../../ExecuteQuery",
            data: formExecute,
            success: function(result){
                resultExec.empty();
                $('#myModalExec').modal('show')
                resultExec.html("<br><div class='span12'>"+result+"</div>");
            }
        });
        
    });
});