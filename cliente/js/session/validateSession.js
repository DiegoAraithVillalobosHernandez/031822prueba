let user = sessionStorage.getItem("user");
console.log(user)
if (user === "error") {
    window.location.replace("../index.html")
}

