const button = document.getElementById("start-crawl");
console.log(button);

button.addEventListener("click", (e) => {
    axios({
        method: "GET",
        url: "/crawler?browser=chrome",
        data:{}
    }).then((res) => {
        console.log(res);
    });
});
