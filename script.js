document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault(); 

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var userRole = authenticateUser(username, password);

    if (userRole === "librarian") {
        document.getElementById("checkout-form").style.display = "block";
        document.getElementById("login-form").style.display = "none";
    } else {
        document.getElementById("checkout-form").style.display = "block";
        document.getElementById("login-form").style.display = "none";
    }
});
function authenticateUser(username, password) {
    if (username === "librarian" && password === "password") {
        return "librarian";
    } else {
        return "user";
    }
}
