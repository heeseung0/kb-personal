function memberJoinAction() {
    let user = {
        username: document.querySelector("#member_id").value,
        password: document.querySelector("#passwd").value,
        password_confirm: document.querySelector("#user_passwd_confirm").value,
        name: document.querySelector("#name").value,
        mobile1: document.querySelector("#mobile1").value,
        mobile2: document.querySelector("#mobile2").value,
        mobile3: document.querySelector("#mobile3").value,
        email: document.querySelector("#email1").value
    }
    console.log(user);

    let ajaxOption = {
        async: false,
        type: "post",
        url: "/api/member/join",
        contentType: "application/json",
        data: JSON.stringify(user),
        dataType: "json",
        success: (response, textStatus, request) => {
            console.log(response);
            // const successURI = request.getResponseHeader("location");
            // location.replace(successURI + "?email=" + response.data);
        },
        error: (error) => {
            console.log(error.responseJSON);
            window.alert("문제있음");
            // loadErrorMessage(error.responseJSON.data);
            // errorBox(error.responseJSON.data);
        }
    }

    $.ajax(ajaxOption);
}