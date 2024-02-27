document.addEventListener("DOMContentLoaded", function() {
  document.querySelector('form[action="login.jsp"]').addEventListener('submit', function(event) {
    // Prevent the default submission to validate the form
    event.preventDefault();

    var username = this.querySelector('input[name="username"]').value;
    var date = this.querySelector('input[name="date"]').value;

    if (!username || !date) {
      alert("Please fill out all fields.");
    } else {
      // If validation passes, manually submit the form
      this.submit();
    }
  });
});
