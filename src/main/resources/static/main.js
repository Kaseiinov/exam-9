

document.addEventListener('DOMContentLoaded', function() {

    // Получаем элементы ввода
    const departureInput = document.getElementById('departure-input');
    const destinationInput = document.getElementById('destination-input');
    const dateInput = document.getElementById('date-input');

    // Функция фильтрации рейсов
    function filterFlights() {
        const departureValue = departureInput.value.toLowerCase();
        const destinationValue = destinationInput.value.toLowerCase();
        const dateValue = dateInput.value;

        // Получаем все карточки рейсов
        const flightCards = document.querySelectorAll('.list-group-item');

        flightCards.forEach(card => {
            // Извлекаем данные из карточки
            const departureCity = card.querySelector('.departure-city').textContent.toLowerCase();
            const destinationCity = card.querySelector('.destination-city').textContent.toLowerCase();
            const departureDate = card.querySelector('.departure-date').textContent;

            // Проверяем совпадения
            const matchesDeparture = departureValue === '' || departureCity.includes(departureValue);
            const matchesDestination = destinationValue === '' || destinationCity.includes(destinationValue);
            const matchesDate = dateValue === '' || departureDate.includes(dateValue);

            // Показываем/скрываем карточку в зависимости от совпадений
            if (matchesDeparture && matchesDestination && matchesDate) {
                card.style.display = '';
            } else {
                card.style.display = 'none';
            }
        });
    }

    // Назначаем обработчики событий
    departureInput.addEventListener('input', filterFlights);
    destinationInput.addEventListener('input', filterFlights);
    dateInput.addEventListener('input', filterFlights);

    // Инициализация обработчиков для кнопок покупки
    document.querySelectorAll('.buy-btn').forEach(button => {
        button.addEventListener('click', function() {
            const flightId = this.getAttribute('data-id');
            const form = document.querySelector(`.confirm-form[data-id="${flightId}"]`);
            form.classList.toggle('d-none');
        });
    });
});
