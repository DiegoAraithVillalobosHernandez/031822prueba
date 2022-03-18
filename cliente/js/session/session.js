const url = "http://localhost:8080/api/";
const msgDiv = document.getElementById("msg");
msgDiv.style.display = "none";

const findByUsernameAndPassword = async (u, p) => {
    return await $.ajax({
        method: 'GET',
        dataType: 'json',
        url: url+`user/${u}/${p}`,
        success:function(response){
            //console.log(response);
            //console.log(data);
            // console.log(data.length);
        },
        error:function(error){
            //console.log(error.responseJSON);
        }
    }).done(res => res).catch(res => console.log(res));
}

const login = async () => {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let user = await findByUsernameAndPassword(username, password);
    console.log(user)
    sessionStorage.setItem("user", user === null || user === undefined ? "error" : user);
    window.location.replace("./views/products.html");
}

const message = () =>{
    let user = sessionStorage.getItem("user")
    if(user == "error"){
        msgDiv.style.display = "block";
    }
}

message();
