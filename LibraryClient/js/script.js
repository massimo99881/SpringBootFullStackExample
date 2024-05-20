function getAllAuthors() {
    fetch('http://localhost:8080/api/v1/authors')
        .then(function (result) {
            return result.json();
        })
        .then(function (authors) {
            console.log(authors);
            let htmlString = '';
            for (let author of authors) {
                htmlString += `<tr><td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>${author.birthDate}</td>`
                if (author.deathDate != null) {
                    htmlString += `<td>${author.deathDate}</td>`
                } else {
                    htmlString += `<td>--</td>`;
                }
                htmlString += `</tr>`;
            }
            const a = document.querySelector('#tableBody');
            a.innerHTML = htmlString;
        });
}

function getAuthorById(id) {
    fetch(`http://localhost:8080/api/v1/authors/${id}`)
        .then(async function (result) {
            if (!result.ok) {
                const errorMessage = await result.text();
                throw new Error(errorMessage);
            }
            return result.json();
        })
        .then(function (author) {
            console.log(author);
            let htmlString = '';
            htmlString += `<tr><td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>${author.birthDate}</td>`
            if (author.deathDate != null) {
                htmlString += `<td>${author.deathDate}</td>`
            } else {
                htmlString += `<td>--</td>`;
            }
            htmlString += `</tr>`;
            const a = document.querySelector('#tableBody2');
            a.innerHTML = htmlString;
        })
        .catch(function (error) {
            console.error(error);
            alert(error);
            //TODO:return error;
        });
}

function saveAuthor(author) {
    // Opzioni per la richiesta
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(author)
    };
    fetch('http://localhost:8080/api/v1/authors/admin', requestOptions)
        .then(response => {
            if (!response.ok) {
                throw new Error('Errore di rete');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            alert("registrazione avvenuta con successo");
        })
        .catch(error => {
            console.error('Si è verificato un errore:', error);
        });
}

/* Aggiunge al documento un gestore di eventi */
document.addEventListener('DOMContentLoaded', function () {

    // -------- Click su getAllAuthorsBtn -------
    // Otteniamo il riferimento al button
    let button = document.getElementById('getAllAuthorsBtn');
    // Oppure: var button = document.querySelector('#getAllAuthorsBtn');
    // Aggiungiamo un gestore di evento al click del button
    button.addEventListener("click", function () {
        getAllAuthors();
    });
    // -------- Click su getAuthorByIdBtn -------
    // Otteniamo il riferimento al button
    let button2 = document.getElementById('getAuthorByIdBtn');
    // Aggiungiamo un gestore di evento al click del button
    button2.addEventListener("click", function () {
        let id = document.getElementById('getAuthorByIdTxt').value;
        const a = document.querySelector('#tableBody2');
        a.innerHTML = '';
        getAuthorById(id);
    });
    // -------- Click su saveAuthorBtn -------
    let button3 = document.getElementById('saveAuthorBtn');
    // Aggiungiamo un gestore di evento al click del button
    button3.addEventListener("click", function (e) {
        e.preventDefault();
        let firstName = document.getElementById('firstName').value.trim();
        let lastName = document.getElementById('lastName').value.trim();
        let birthDate = document.getElementById('birthDate').value;
        let deathDate = document.getElementById('deathDate').value;
        if (!firstName) {
            alert('manca il nome');
        } else if (!lastName) {
            alert('manca il cognome');
        } else if (!birthDate) {
            alert('manca la data di nascita');
        } else if (deathDate && deathDate <= birthDate) {
            alert('la data di morte non puo\' essere minore della data di nascita');
        } else {
            // Dati da passare al server
            let author = {
                firstName: firstName,
                lastName: lastName,
                birthDate: birthDate,
                deathDate: deathDate
            };
            saveAuthor(author); 
        }
        document.getElementById('saveAuthorForm').reset();
    });
});

