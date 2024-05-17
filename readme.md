# Flipkart Test Automation Suite

This project is a Selenium-based test automation suite for the Flipkart website. The suite covers various functionalities and flows across different pages of the site, ensuring comprehensive test coverage.

## Project Structure

- **src/test/java/tests:** Contains the test classes.
- **src/test/java/pages:** Contains the different Test pages.
- **src/test/java/utils:** Contains the utility file for excel sheet .
- **src/test/java/readData** Contains test data files (Excel sheets).
- **src/test/java/listeners** Contains listener file to take screenshot.
- **logs:** Contains log files.
- **reports:** Contains generated test reports (Extent Reports).
- **reports/screenshot:** Contains screenshot of failed testcases.
- **src/main/resources/drivers:** Contains all the drivers Chrome,Firefox,internetExplorer.
- **src/main/resources/config :** Contains config.properties file.


## Prerequisites

- Java 8 or higher
- Maven
- Browsers: Chrome, Firefox, Internet Explorer
- ChromeDriver, GeckoDriver, IEDriverServer

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Install Dependencies:**
   ```bash
   mvn clean install
   ```

3. **Configuration:**
   - Update `config/config.properties` with global parameters such as browser type, base URL, etc.
   - Update `data/TestData.xlsx` with test data.

###Logging and report

- The project uses Java's Logger to log important steps and information during the test execution. Logs are printed to the console.

- Extent Reports are generated in the `reports` directory.

## Project Features

- **Page Object Model (POM):** Implemented using Page Factory for better maintenance and readability.
- **Excel Data Provider:** Test data is read from an Excel sheet (`data/TestData.xlsx`). Tests are selectively executed based on the "Execution Required" field.
- **Configuration Files:** Global parameters are managed using config files.
- **Waits:** Proper usage of implicit and explicit waits for stable test execution.
- **Cross-Browser Testing:** Supports Chrome, Firefox, and Internet Explorer.
- **Headless Mode:** Option to run tests in headless mode for faster execution.
- **TestNG:** Utilizes TestNG for grouping, prioritization, and enable/disable functionality.
- **Assertions:** Comprehensive assertions are used throughout the suite.
- **Extent Reports:** Detailed reports with screenshots on failure.
- **Logging:** Logging implemented .


