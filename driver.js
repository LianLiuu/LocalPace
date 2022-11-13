var runspeed = 6;
var jogspeed = 3;
var bikespeed = 10;

function degrees_to_radians(degrees){
     return degrees * (Math.PI/180);
}

function calculateDistance(lat, lon, lat2, lon2){
     let R = 6371;
     let latDistance = degrees_to_radians(lat2 - lat);
     let lonDistance = degrees_to_radians(lon2 - lon);
     let a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
         + Math.cos(degrees_to_radians(lat)) * Math.cos(degrees_to_radians(lat2))
         * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
     //let c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
     let distance = R *  2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)) * 1000;
     let miles = distance * 0.00062137119;
     return miles;
 }

function runningTime(dis) {
     let hour=dis/runspeed;
     let time=hour * 60;
     return time;
}

function joggingTime(dis) {
     let hour=dis/jogspeed;
     let time=hour * 60;
     return time;
}

function bikingTime(dis){
     let hour=dis/bikespeed;
     let time=hour * 60;
     return time;
}

function compileInfo() {
     for (key in locations){
         let store = {};
         let coords = locations[key];
         let distance = calculateDistance(coords[0],coords[1]);
         store['name'] = key;
         store['distance'] = distance;
         store['runningtime'] = runningTime(distance);
         store['joggingtime'] = joggingTime(distance);
         store['bikingtime'] = bikingTime(distance);
         final.push(store)
     }
}
var locations = {"LemonThai": [42.29694883773992,-71.29251805429472],"LatinaKitchen&Bar":[42.280455838035564,-71.24236580873706],"RippleCafe":[42.2846788628447,-71.0642963984735]}

$("#submit").click(function(event){
     if ( $("#output").children().length != 0 ){
          $("#output").empty();
     }
     event.preventDefault();
     var long = $("#long").val();
     var lat = $("#lat").val();
     var final = [];
     for (let key in locations){
          let store = {};
          let coords = locations[key];
          let distance = calculateDistance(lat,long,coords[0],coords[1]);
          store['name'] = key;
          store['distance'] = distance;
          store['runningtime'] = runningTime(distance);
          store['joggingtime'] = joggingTime(distance);
          store['bikingtime'] = bikingTime(distance);
          final.push(store);
          console.log(final);
     }

     final.forEach(function (element){
          var elt = $("<li>");
          elt.text(element['name'] + ": Distance is " +  Math.round(element['distance'])+" miles; Running takes "+ Math.round(element['runningtime'])+" minutes; Jogging takes "+ Math.round(element['joggingtime'])+" minutes; Biking takes "+ Math.round(element['bikingtime'])+" minutes");
          $("#output").append(elt);
     });
});

    



