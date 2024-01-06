


document.addEventListener("DOMContentLoaded", function () {
    // Dropdown setup
    // Call the function to show the initial slide
    function setupDropdown(menuId, dropdownContentId) {
        let menu = document.getElementById(menuId);
        let dropdownContent = document.getElementById(dropdownContentId);

        menu.addEventListener("mouseover", function () {
            dropdownContent.style.display = "block";
        });

        menu.addEventListener("mouseout", function () {
            dropdownContent.style.display = "none";
        });
    }

    // Setup for menu
    setupDropdown("menu", "dropdownContentMenu");

    // Slideshow setup
    let slideIndex = 0;

    function showSlides() {
        let slides = document.getElementsByClassName("slides");
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }

        if (slideIndex >= slides.length) {
            slideIndex = 0;
        }

        if (slideIndex < 0) {
            slideIndex = slides.length - 1;
        }

        slides[slideIndex].style.display = "block";
    }

    // Function to initialize slideshow
    function initializeSlideshow() {
        slideIndex = 0;
        showSlides();

        // Add event listeners for next and previous buttons
        let nextButton = document.querySelector(".next");
        let prevButton = document.querySelector(".prev");

        nextButton.addEventListener("click", function () {
            slideIndex++;
            showSlides();
        });

        prevButton.addEventListener("click", function () {
            slideIndex--;
            showSlides();
        });
    }

    // Call the function to show the initial slide
    initializeSlideshow();


    let searchContainer = document.querySelector(".search");
    let searchIcon = searchContainer.querySelector("i");
    let searchInput = searchContainer.querySelector("input");

    searchIcon.addEventListener("click", function () {
        // Toggle visibility of the search input on icon click
        searchInput.style.display = (searchInput.style.display === "none") ? "block" : "none";
    });

    // Function to initialize login button
    function initializeLoginButton() {
        let loginButton = document.getElementById("loginButton");
        loginButton.addEventListener("click", function () {
            // Clear content of additional-div1
            let additionalDiv1 = document.querySelector(".additional-div1");
            additionalDiv1.innerHTML = '';

            // Make additional-div1 a flex container with row layout
            additionalDiv1.classList.add("flex-container-row");

            // Add the first div with the login form
            let loginFormDiv = document.createElement("div");
            loginFormDiv.classList.add("login-form");
            loginFormDiv.innerHTML = `
            <div class="login-form-container">
                <h2>Log in to your profile:</h2>
                <label for="login">Login</label>
                <input type="text" id="login" name="login" required>

                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>

                <button type="submit" id="submitButton">Log in</button>
            </div>
        `;
            additionalDiv1.appendChild(loginFormDiv);

            // Add the second div with two links
            let linkContainer = document.createElement("div");
            linkContainer.classList.add("link-container");

            let link1 = document.createElement("a");
            link1.href = "#"; // Set the href attribute as needed
            link1.textContent = "Forgot your password?";

            let link2 = document.createElement("a");
            link2.href = "#"; // Set the href attribute as needed
            link2.textContent = "Do not have an account yet?";
            link2.classList.add("registration-link"); // Add the class for the registration link

            linkContainer.appendChild(link1);
            linkContainer.appendChild(link2);
            additionalDiv1.appendChild(linkContainer);

            initializeSubmitButton();

            // Clear content of additional-div2
            let additionalDiv2 = document.querySelector(".additional-div2");
            additionalDiv2.innerHTML = '';

            // Reinitialize slideshow and login button functionality
            initializeSlideshow();
            initializeLoginButton();
        });
    }

    function initializeSubmitButton() {
        let submitButton = document.getElementById("submitButton");
        submitButton.addEventListener("click", function (event) {
            event.preventDefault();
            let email = document.getElementById("login").value;
            let password = document.getElementById("password").value;

            logInSubmission(email, password);
            callLogInFunction(email, password);
        });
    }

    function logInSubmission() {
        let email = document.getElementById("login").value;
        let password = document.getElementById("password").value;

        callLogInFunction(email, password);
    }

    function callLogInFunction(email, password) {
        fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: `email=${email}&password=${password}`,
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

// Call the function to initialize login button
    initializeLoginButton();


    function handleRegistrationLink() {
        let observer = new MutationObserver(function (mutationsList) {
            mutationsList.forEach(function (mutation) {
                if (mutation.type === "childList" && mutation.addedNodes.length > 0) {
                    // Check if the added nodes include the registration link
                    let registerLink = document.querySelector(".registration-link");
                    if (registerLink) {

                        registerLink.addEventListener("click", function () {

                            // Clear content of additionalDiv2
                            let additionalDiv2 = document.querySelector(".additional-div2");
                            additionalDiv2.innerHTML = '';

                            // Change content of additionalDiv1 to registration form
                            let additionalDiv1 = document.querySelector(".additional-div1");
                            additionalDiv1.innerHTML = `
                <div class="registration-form">
                  <h2>Create a new account:</h2>
                  <div class="sections">
                  <div class="section">
                  <label for="username">Imię</label>
                  <input type="text" id="username" name="username" required>

                  <label for="email">Nazwisko</label>
                  <input type="email" id="email" name="email" required>

                  <label for="password">Hasło</label>
                  <input type="password" id="password" name="password" required>
                   <label for="password">Powtórz hasło</label>
                  <input type="password" id="password" name="password" required>

                  </div>
                   <div class="section">
                  <label for="dataUrodzenia">Data urodzenia:</label>
  <input type="date" id="dataUrodzenia" name="dataUrodzenia" required>


                  <label for="numerTelefonu">Numer telefonu:</label>
  <input type="tel" id="numerTelefonu" name="numerTelefonu" pattern="[0-9]{9}" required>

 <label for="email">Email:</label>
  <input type="email" id="email" name="email" required>
                  </div>
									</div>
                  <button type="submit">Register</button>
                </div>
              `;

                            // Disconnect the observer since we found the link
                            observer.disconnect();
                        });
                    }
                }
            });
        });

        // Start observing changes to the body (or a more specific element if possible)
        observer.observe(document.body, { childList: true, subtree: true });
    }

    // Call the function to handle the registration link
    handleRegistrationLink();

    // Setup for Sieć bibliotek click
    let siecBibliotekDiv = document.querySelector(".logo");
    siecBibliotekDiv.addEventListener("click", function () {
        // Restore default content
        let additionalDiv1 = document.querySelector(".additional-div1");
        additionalDiv1.innerHTML = `
            <div id="slideshow" class="slider-container">
                <button class="prev">&#10094;</button>
                <img class="slides" src="" alt="Slide 1">
                <img class="slides" src="" alt="Slide 2">
                <img class="slides" src="" alt="Slide 3">
                <img class="slides" src="" alt="Slide 4">
                <img class="slides" src="" alt="Slide 5">
                <button class="next">&#10095;</button>
            </div>
        `;

        // Restore default content in additional-div2
        let additionalDiv2 = document.querySelector(".additional-div2");
        additionalDiv2.innerHTML = `
            <button class="login-button" id="loginButton">
                <i class="fa-regular fa-user fa-lg"></i>
                <span class="button-text">Log in</span>
            </button>
        `;

        // Reinitialize slideshow and login button functionality
        initializeSlideshow();
        initializeLoginButton();
    });

// Setup for Kontakt click
    let kontaktPage = document.querySelector(".kontakt");
    kontaktPage.addEventListener("click", function () {
        // Create overlay div
        let overlayDiv = document.createElement("div");
        overlayDiv.classList.add("overlay");

        // Prompt content with header and location options
        let contentDiv = document.createElement("div");
        contentDiv.classList.add("overlay-content");
        contentDiv.innerHTML = `
        <h2>Wybierz filię</h2>
        <div class="location-list">
            <div class="selected-location">
                Wybierz z listy <i class="fa-solid fa-caret-down"></i>
            </div>
            <div class="all-locations">
                <div>Filia Dąb</div>
                <div>Filia Wierzba</div>
                <div>Filia Sosna</div>
            </div>
        </div>
    `;

        // Append content to overlay div
        overlayDiv.appendChild(contentDiv);

        // Append overlay div to the body
        document.body.appendChild(overlayDiv);

        // Adjust styling for the location options
        let selectedLocation = contentDiv.querySelector(".selected-location");
        let allLocations = contentDiv.querySelector(".all-locations");

        // Initial state: show only the selected location
        allLocations.style.display = "none";

        // Add event listener to toggle visibility of locations on click
        selectedLocation.addEventListener("click", function () {
            if (allLocations.style.display === "block") {
                allLocations.style.display = "none";
            } else {
                allLocations.style.display = "block";
            }
        });

        // Close overlay when clicking outside the content
        overlayDiv.addEventListener("click", function (event) {
            if (!contentDiv.contains(event.target)) {
                // Click outside the content, close overlay
                overlayDiv.remove();
            }
        });
    });

    let katalogDropdown = document.querySelector(".menu .dropdown-content div:first-child");
    katalogDropdown.addEventListener("click", function () {
        // Clear the content of additional-div1
        let additionalDiv1 = document.querySelector(".additional-div1");
        additionalDiv1.innerHTML = `
           <div id="bookDetails">
    <p>Autor: <span id="bookData"></span></p>
    <!-- Dodaj więcej informacji, jeśli są dostępne -->
    </div>`;

        fetch('http://localhost:3000/api/data')
            .then(response => response.json())
            .then(data => {
                const resultContainer = document.getElementById('bookData');

                // Assuming each object in the array has an 'author' property
                const authors = data.map(item => item.author);

                // Join the authors into a single string separated by line breaks
                const displayedString = authors.join('<br>');

                // Set the result as the innerHTML
                resultContainer.innerHTML = displayedString;
            })
            .catch(error => console.error('Error fetching data:', error));
    });
});
