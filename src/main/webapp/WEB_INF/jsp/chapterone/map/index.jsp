<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <style>
        svg circle {
          fill: orange;
          opacity: .5;
          stroke: white;
        }
        svg circle:hover {
          fill: green;
          stroke: #333;
        }
        svg text {
          pointer-events: none;
        }
        svg .municipality {
          fill: #efefef;
          stroke: #fff;
        }
        svg .municipality-label {
          fill: #bbb;
          font-size: 12px;
          font-weight: 300;
          text-anchor: middle;
        }
        svg #map text {
          color: #333;
          font-size: 10px;
          text-anchor: middle;
        }
        svg #places text {
          color: #777;
          font: 10px sans-serif;
          text-anchor: start;
        }
        #title {
            font-family: sans-serif;
        }
        #title p {
            font-size: 10pt;
        }
        
        
    </style>
  </head>
  <body>
    <center><div id="chart"></div></center>
    <div id="title">
        <p>D3.js, TopoJSON을 이용해 지도를 그렸습니다.</p>
        <p>지도 만드는 법은 <a href="http://www.lucypark.kr/blog/2015/06/24/seoul-matzip-mapping/">D3를 이용한 서울시내 맛집 시각화 (Feat. 식신로드)</a>를 참고해주세요.
        <p>
          <br>
          <a href="http://opensource.org/licenses/Apache-2.0">Licensed with Apache 2.0</a>
        </p>
    </div>
    <script src="http://d3js.org/d3.v3.min.js"></script>
    <script src="http://d3js.org/topojson.v1.min.js"></script>
    <script>
    var width = 800,
        height = 600;

    var svg = d3.select("#chart").append("svg")
        .attr("width", width)
        .attr("height", height);

    var map = svg.append("g").attr("id", "map"),
        places = svg.append("g").attr("id", "places");

    var projection = d3.geo.mercator()
        .center([126.9895, 37.5651])
        .scale(100000)
        .translate([width/2, height/2]);

    
    var path = d3.geo.path().projection(projection);
    var jsonPath='/resources/map/seoul_municipalities_topo_simple.json';
    var csvPath = '/resources/map/places.csv';
    
    d3.json(jsonPath, function(error, data) {
      var features = topojson.feature(data, data.objects.seoul_municipalities_geo).features;
      map.selectAll('path')
          .data(features)
        .enter().append('path')
          .attr('class', function(d) { console.log(); return 'municipality c' + d.properties.code })
          .attr('d', path);

      map.selectAll('text')
          .data(features)
        .enter().append("text")
          .attr("transform", function(d) { return "translate(" + path.centroid(d) + ")"; })
          .attr("dy", ".35em")
          .attr("class", "municipality-label")
          .text(function(d) { return d.properties.name; })
    });

    
    d3.csv(csvPath, function(data) {
        places.selectAll("circle")
            .data(data)
          .enter().append("circle")
            .attr("cx", function(d) { return projection([d.lon, d.lat])[0]; })
            .attr("cy", function(d) { return projection([d.lon, d.lat])[1]; })
            .attr("r", 10);

        places.selectAll("text")
            .data(data)
          .enter().append("text")
            .attr("x", function(d) { return projection([d.lon, d.lat])[0]; })
            .attr("y", function(d) { return projection([d.lon, d.lat])[1] + 8; })
            .text(function(d) { return d.name });
    });
    </script>
  </body>
</html>
