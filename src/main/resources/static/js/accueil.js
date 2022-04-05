var a;
function show_hide() {
  if (a == 1) {
    // document.getElementById("image").style.display = "inline";
    document.getElementById("image").style.visibility = "visible";
    return (a = 0);
  } else {
    // document.getElementById("image").style.display = "none";
    document.getElementById("image").style.visibility= "hidden";
    return (a = 1);
  }
}
