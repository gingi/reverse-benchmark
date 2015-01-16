#!/usr/bin/env node

"use strict";

var INPUT =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin libero "   +
    "mi, euismod efficitur laoreet at, elementum et lectus. Curabitur "        +
    "finibus velit vel egestas vestibulum. Aliquam porta blandit ipsum, quis " +
    "imperdiet purus ornare eget. Nullam in lectus nec massa finibus "         +
    "posuere. In molestie ut ipsum tempor interdum. Nulla accumsan risus ut "  +
    "diam ornare ultricies. Maecenas eu sollicitudin augue. Proin eu nulla "   +
    "lobortis, sodales dolor et, bibendum nisl. Integer vitae est ac purus "   +
    "condimentum mollis. Quisque bibendum nunc ac lorem ultricies, et "        +
    "sagittis nunc fermentum. Nullam tincidunt egestas neque, ac luctus "      +
    "massa bibendum nec. Nunc tincidunt porta mattis. Fusce eget sem at "      +
    "lacus dapibus ullamcorper. Vestibulum maximus ligula at justo volutpat "  +
    "semper. Donec tincidunt quis arcu et interdum. Integer a mauris ut mi "   +
    "fringilla pharetra."

function reverse1(str) {
    return str.split("").reverse().join("");
}

function reverse2(str) {
    for (var i = str.length - 1, out = ""; i >= 0; out += str[i--]);
    return out;
}

var times = parseInt(process.argv[2]),
    type = process.argv[3],
    method;
if (typeof type === "undefined") {
    type = "1";
}

switch (type) {
    case "1": method = reverse1; break;
    case "2": method = reverse2; break;
    default:
        console.error("No such method");
        process.exit(1);
}

var time = new Date().getTime();
for (var i = 0; i < times; i++) {
    method(INPUT);
}
console.log((new Date().getTime() - time) / 1000);
