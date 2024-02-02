var Api = {
    login(username, password) {
        return new Promise(((resolve, reject) => {
            $.ajax({
                url: "/login?username=" + username + "&password=" + password ,
                method: "GET",
                success: (resp) => {
                    resolve(resp)
                },
            })

        }))

    },
    getAllCounselors() {
        return new Promise(((resolve, reject) => {
            $.ajax({
                url: "/getAllCounselor",
                method: "GET",
                success: (resp) => {
                    resolve(resp)
                },
            })

        }))

    },
    getStudentById(id) {
        return new Promise(((resolve, reject) => {
            $.ajax({
                url: "/getStudentById?id=" + id,
                method: "GET",
                success: (resp) => {
                    resolve(resp)
                },
            })

        }))

    },
    addLeave(Leave) {
        return new Promise(((resolve, reject) => {
            $.ajax({
                url: "/addLeave",
                method: "GET",
                data: {
                    student:Leave.name,
                    counselor:Leave.counselor,
                    start_time:Leave.startDate,
                    reason:Leave.reason,
                    end_time:Leave.endDate,
                    days:Leave.days,
                    tel:Leave.phone
                },
                success: (resp) => {
                    resolve(resp)
                },
            })

        }))

    },
    getLeave(studentName,counselorName) {
        var data ={}
        if(studentName=="")
            data = {
                counselor:counselorName
            }
        else{
            data = {
                student:studentName
            }
        }
        return new Promise(((resolve, reject) => {
            $.ajax({
                url: "/getLeave",
                method: "GET",
                data: data,
                success: (resp) => {
                    resolve(resp)
                },
            })

        }))

    },
    updataStatus(leave){
        return new Promise(((resolve, reject) => {
            $.ajax({
                url: "/updataStatus",
                method: "GET",
                data: {
                    id:leave.id,
                    status:leave.status,
                    reason:leave.reason,
                    remarks:leave.remarks

                },
                success: (resp) => {
                    resolve(resp)
                },
            })

        }))
    },
    delLeave(id){
        return new Promise(((resolve, reject) => {
            $.ajax({
                url: "/delLeave",
                method: "GET",
                data: {
                    id:id,


                },
                success: (resp) => {
                    resolve(resp)
                },
            })

        }))
    }
}


function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}