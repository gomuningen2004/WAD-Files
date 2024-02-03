function calculateAttendance() {
    // Get input values
    var totalStrength = parseFloat(document.getElementById('totalStrength').value);
    var presentees = parseFloat(document.getElementById('presentees').value);

    // Check if input values are valid numbers
    if (!isNaN(totalStrength) && !isNaN(presentees)) {
        // Calculate absentees and today's class strength
        var absentees = totalStrength - presentees;
        var todaysClassStrength = presentees;

        // Display results
        document.getElementById('absentees').value = absentees;
    } else {
        alert("Please enter valid numeric values for Total Strength and Presentees.");
    }
}

