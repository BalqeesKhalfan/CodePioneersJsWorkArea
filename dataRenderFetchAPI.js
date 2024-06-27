const tableBodyObj = document.getElementById("tableBody");

fetch("https://api.github.com/users/BalqeesKhalfan")
.then((response) => {return response.json();})
.then((jsonRes) => {
  Object.keys(jsonRes).forEach((attribName) => {
    const newTrObj = document.createElement("tr");

    const newDataCol1 = document.createElement("td");
    newDataCol1.innerText = attribName;

    const newDataCol2 = document.createElement("td");
    newDataCol2.innerText = jsonRes[attribName];

    newTrObj.appendChild(newDataCol1);
    newTrObj.appendChild(newDataCol2);

    tableBodyObj.appendChild(newTrObj);
  });
})
.then(() => {console.log("I am done!");})
.catch((errMsg) => {console.log(`Error Message: ${errMsg}.`);});




  