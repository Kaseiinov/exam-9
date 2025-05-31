window.onload = function () {
    const buttons = document.querySelectorAll('.buy-btn');
    buttons.forEach(button => {
        button.addEventListener('click', function () {
            const id = button.getAttribute('data-id');
            const form = document.querySelector(`.confirm-form[data-id="${id}"]`);
            form.classList.toggle('d-none');
        })
    })
}