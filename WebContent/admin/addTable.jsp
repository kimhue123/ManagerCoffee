<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/templates/inc/header.jsp" %>
<%@include file="/templates/inc/left_bar.jsp" %>



        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Add Table
                            <small>Add</small>
                        </h1>
                        
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:120px">
                        <form action="" method="post">
                            <div class="form-group">
                                <label>Name Table</label>
                                <input class="form-control" name="nameTable" placeholder="Please Enter Username" />
                            </div>
                            
                            
                            
                            <button type="submit" name= "submit" class="btn btn-default" > Add</button>
                           <!--  <button type="reset" class="btn btn-default">Reset</button> -->
                        </form>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    
</body>

</html>
