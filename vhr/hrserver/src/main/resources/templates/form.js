$("#lg-btn").click(function () {
    $.ajax({
        dataType: "JSON",
        contentType: "Application/json",
        type: "post",
        url: "/login",
        // data: "{'user_Name':'"+user_name+"','stu_id':'" + stu_id.val() + "','stu_name':'" + stu_name.val() + "','stu_major':'" + stu_major.val()
        // + "','stu_dept':'"+stu_dept.val()+"'}",
        suceess: function(data) {
            alert(data.d);
        },
        error: function() {
            alert("chucuole");
        }
    });
})