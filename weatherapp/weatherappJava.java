let now = new Date();

console.log(now.getDate());
console.log(now.getMilliseconds());
console.log(now.getDay());
console.log(now.getFullYear());
console.log(now.getMonth());

let date = now.getDate();
let year = now.getFullYear();

let days = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
let day = days[now.getDay()];

let months = [
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December"
];
let month = months[now.getMonth()];

let h1 = document.querySelector("h1");
h1.innerHTML = `Today is ${day}, ${month} ${date}, ${year}`;

function citySearched(event) {
  event.preventDefault();

  let cityInput = document.querySelector("#newcity-search");
  let apiKey = "c70433e7af84bfd05bd329a4cb014923";
  let apiUrl = "https://api.openweathermap.org/data/2.5/weather?";

  axios
    .get(`${apiUrl}q=${cityInput.value}&units=metric&appid=${apiKey}`)
    .then(showWeather);
}
let newCity = document.querySelector("#city-search");
newCity.addEventListener("submit", citySearched);

function showWeather(response) {
  document.querySelector("h2").innerHTML = response.data.name;
  document.querySelector("h3").innerHTML = Math.round(response.data.main.temp
  );
}

function conversionFarenheit(event) {
  event.preventDefault();
  let cityInput = document.querySelector("#newcity-search");
  let changeTemp = document.querySelector("h2");
  changeTemp.innerHTML = `${cityInput.value} 62°F`;
}

let convertTemp = document.querySelector("#farenheit");
convertTemp.addEventListener("click", conversionFarenheit);

function conversionCelcius(event) {
  event.preventDefault();
  let cityInput = document.querySelector("#newcity-search");
  let changeTemp = document.querySelector("h2");
  changeTemp.innerHTML = `${cityInput.value} 17°C`;
}

let convertCel = document.querySelector("#celcius");
convertCel.addEventListener("click", conversionCelcius);

function coordsWeather(event) {
  let apiKey = "c70433e7af84bfd05bd329a4cb014923";
  let apiUrl = "https://api.openweathermap.org/data/2.5/weather?";
  let lat = position.coords.latitude;
  let lon = position.coords.longitude;
  axios
    .get(`${apiUrl}lat=${lat}&lon=${lon}&units=metric&appid=${apiKey}`)
    .then(weatherHere);
}
navigator.geolocation.getCurrentPosition(coordsWeather);


function weatherHere(response) {
  let temp = Math.round(response.data.main.temp);
  let h2 = document.querySelector("h2");
  h2.innerHTML = `It is currently ${temp}°`;
}
let currentCoords = document.querySelector("#gpsLocation");
currentCoords.addEventListener("click", coordsWeather);
