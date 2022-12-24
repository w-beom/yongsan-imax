const button = document.getElementById("start-crawl");
console.log(button);

button.addEventListener("click", (e) => {
    axios({
        method: "POST",
        url: "/crawler",
        data: {}
    }).then((res) => {
        console.log(res);
    });
});
