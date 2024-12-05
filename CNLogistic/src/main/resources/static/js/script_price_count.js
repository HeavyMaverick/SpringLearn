const CNY_TO_RUB_RATE = 15;
const COMMISSION = 1500;

// Обработчик нажатия клавиши Enter
function handleKeyDown(event) {
    if (event.key === "Enter") {
        event.preventDefault(); // Предотвращаем стандартное поведение формы
        calculateCost();
    }
}

function calculateCost() {
    let amountCny = document.getElementById("amountCny").value;
    if (!amountCny || isNaN(amountCny) || parseFloat(amountCny) <= 0) {
        alert("Введите правильную сумму в юанях.");
        return;
    }

    let costInRubles = (parseFloat(amountCny) * CNY_TO_RUB_RATE).toFixed(2);
    let totalCost = (parseFloat(costInRubles) + COMMISSION).toFixed(2);
    document.getElementById("total-cost").innerText = totalCost;
    document.getElementById("calculator-form").classList.add("hidden");
    document.getElementById("result-container").classList.remove("hidden");
}

function resetCalculator() {
    document.getElementById("amountCny").value = "";
    document.getElementById("calculator-form").classList.remove("hidden");
    document.getElementById("result-container").classList.add("hidden");
}

// Функция для отправки данных заказа на сервер
async function createOrder() {
    let amountCny = document.getElementById("amountCny").value;
    let totalCost = document.getElementById("total-cost").innerText;

    try {
        const response = await fetch("/orders", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                amountCny: amountCny,
                totalCost: totalCost
            })
        });

        if (response.ok) {
            alert("Заказ успешно создан!");
            resetCalculator();
        } else {
            throw new Error(`Ошибка создания заказа: ${response.status}`);
        }
    } catch (error) {
        console.error(error);
        alert("Произошла ошибка при создании заказа.");
    }
}