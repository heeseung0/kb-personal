function memberJoinAction() {
    const username = document.querySelector("#member_id");
    const password = document.querySelector("#passwd");
    const password_confirm = document.querySelector("#user_passwd_confirm");
    const name = document.querySelector("#name");
    const mobile1 = document.querySelector("#mobile1");
    const mobile2 = document.querySelector("#mobile2");
    const mobile3 = document.querySelector("#mobile3");
    const email = document.querySelector("#email1");

    if(password.value != password_confirm.value) {
        alert("Passwords do not match");
        return;
    }

    let mobile = mobile1.value + mobile2.value + mobile3.value;

    let user = {
        username: username.value,
        password: password.value,
        name: name.value,
        mobile: mobile,
        email: email.value,
        role: 1
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
             const successURI = request.getResponseHeader("location");
             location.replace(successURI + "?username=" + response.data);
        },
        error: (error) => {
            console.log(error.responseJSON);
            alertErrorMessage(error.responseJSON.data);
            // loadErrorMessage(error.responseJSON.data);
            // errorBox(error.responseJSON.data);
        }
    }

    $.ajax(ajaxOption);
}

function alertErrorMessage(errors){
    const errorArray = Object.values(errors);

    window.alert(errorArray[0]);
}