// An array of image filenames
const imageArray = [
    'image1.jpg',
    'image2.jps',

    // Add more image filenames here
];

// Function to set a random background image
function setRandomBackground() {
    const backgroundImage = imageArray[Math.floor(Math.random() * imageArray.length)];
    const backgroundContainer = document.getElementById('background-container');
    backgroundContainer.style.backgroundImage = `url('/image/${backgroundImage}')`;
}

// Call the function to set a random background on page load
setRandomBackground();