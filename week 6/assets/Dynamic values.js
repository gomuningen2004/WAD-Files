var helpers = [
    "Your name must be in the form: \n \first name, middle name, last name",
    "Your email address must have the form: \ user@domain.com",
    "Your user ID must have atleast 6 characters",
    "Your password must have atleast 6 \ charactersand it must include 1 digit",
    "This box provides advice on what to fill in respective fields when you put the mouse over it"
]

function messages(advicenumber){
    document.getElementById("advicebox").value = helpers[advicenumber];
}