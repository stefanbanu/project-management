var chartDataDecrypted = decodeHtml(chartData);
var parsedJsonArray = JSON.parse(chartDataDecrypted);

var arrayLength = parsedJsonArray.length;
var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
    numericData[i] = parsedJsonArray[i].value;
    labelData[i] = parsedJsonArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

// "[{},{},{}]" decrypts json
function decodeHtml(html) {
    var htmlTextAreaElement = document.createElement("textarea");
    htmlTextAreaElement.innerText = html;
    return htmlTextAreaElement.value;
}