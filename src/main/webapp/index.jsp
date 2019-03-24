<html>
<jsp:include page="beforeHeader.jsp" />
<jsp:include page="footer.jsp" />
<head>
<style type="text/css">

.button {
    display: block;
    width: 115px;
    text-align:center;

    height: 100px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}

</style>

</head>
<body>


<div class=" container container-fluid" style="padding-left: 20%;padding-right: 20%;padding-top: 5%">
 <h1>Welcome to Token System</h1><br>
  
  <div class="row">
    <div class="col-lg-6">
   <a class="button" href="generateToken.jsp"><br>Generate Token</a>
    </div>
    <div class="col-lg-6" >
    <a  class="button" href="<%=request.getContextPath()%>/getCounterQueue"><br>View Counter Queue</a>
    </div>
  </div>
 
 
</div>

</body>
</html>
