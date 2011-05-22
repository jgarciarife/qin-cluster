<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

 <script type="text/javascript" src="Charts/FusionCharts.js">
 </script>

    <div id="chartContainer">FusionCharts will load here!</div>          
    <script type="text/javascript">         

      var myChart = new FusionCharts( "Charts/Column3D.swf", 
      "myChartId", "400", "300", "0", "1" );

      myChart.setJSONData(
              { 
                      "chart": 
       { 
                               "caption" : "Weekly Sales Summary" ,   
                               "xAxisName" : "Week", 
                               "yAxisName" : "Sales", 
                               "numberPrefix" : "$" 
                      },
                      
                      "data" : 
                      [ 
                              { "label" : "Week 1", "value" : "14400" },
                              { "label" : "Week 2", "value" : "19600" }, 
                              { "label" : "Week 3", "value" : "24000" }, 
                              { "label" : "Week 4", "value" : "15700" } 
                      ]
              }
      );

      
      myChart.render("chartContainer");
      
    
    </script>      
