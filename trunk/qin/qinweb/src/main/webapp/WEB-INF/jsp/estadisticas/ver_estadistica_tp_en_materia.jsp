<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<script type="text/javascript" src="Charts/FusionCharts.js"></script>

<div id="chartContainer">Cantidad de trabajos prácticos de la materia elegida, por nota</div>

<script type="text/javascript">
	var myChart = new FusionCharts("Charts/Column3D.swf", "myChartId", "600", "400", "0", "1");
	myChart.setJSONData(
		{
			"chart":	{
							"caption" :	"Cantidad de trabajos prácticos de la materia elegida, por nota",
										"xAxisName" : "Nota",
										"yAxisName" : "Cantidad de trabajos prácticos de la materia elegida",
										"numberPrefix" : "Cant. TPs: "
						},
			"data" :	[
							<%= request.getAttribute("tabla") %>
						]
		}
	);
	myChart.render("chartContainer");
</script>