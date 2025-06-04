/**
 * Restaurant Table Manager
 * Main JavaScript file
 */

document.addEventListener('DOMContentLoaded', function () {
    // Initialize UI elements
    initializeUI();

    // Add event listeners
    setupEventListeners();

    // Initialize tooltips
    initializeTooltips();

    // Animate tables on load
    animateTablesOnLoad();

   
});

/**
 * Initialize UI elements
 */
function initializeUI() {
    // Set current date
    const currentDate = new Date();
    const formattedDate = currentDate.toLocaleDateString('en-US', {
        weekday: 'short',
        day: 'numeric',
        month: 'long',
        year: 'numeric'
    });

    const dateElement = document.getElementById('lblCurrentDate');
    if (dateElement) {
        dateElement.textContent = formattedDate;
    }
}

/**
 * Setup event listeners
 */
function setupEventListeners() {
    // Table item hover effects
    const tableItems = document.querySelectorAll('.table-item');
    tableItems.forEach(function (item) {
        item.addEventListener('mouseenter', function () {
            this.style.transform = 'translateY(-5px)';
            this.style.boxShadow = 'var(--shadow-md)';
        });

        item.addEventListener('mouseleave', function () {
            this.style.transform = 'translateY(0)';
            this.style.boxShadow = 'none';
        });

        item.addEventListener('click', function () {
            const tableId = this.getAttribute('data-table-id');
            showTableDetails(tableId);
        });
    });

    // Reservation card hover effects
    const reservationCards = document.querySelectorAll('.reservation-card');
    reservationCards.forEach(function (card) {
        card.addEventListener('mouseenter', function () {
            this.style.transform = 'translateY(-5px)';
            this.style.boxShadow = 'var(--shadow-md)';
        });

        card.addEventListener('mouseleave', function () {
            this.style.transform = 'translateY(0)';
            this.style.boxShadow = 'var(--shadow-sm)';
        });
    });

    // Modal close button
    const closeBtn = document.querySelector('.close-btn');
    if (closeBtn) {
        closeBtn.addEventListener('click', closeModal);
    }

    // Close modal when clicking outside
    window.addEventListener('click', function (event) {
        const modal = document.getElementById('addReservationModal');
        if (event.target === modal) {
            closeModal();
        }
    });

    // Add reservation button
    const addReservationBtn = document.querySelector('.add-reservation-btn');
    if (addReservationBtn) {
        addReservationBtn.addEventListener('click', function (e) {
            openModal();
            e.preventDefault(); // Prevent postback if it's an ASP.NET LinkButton
        });
    }

    // Logout button
    const logoutBtn = document.getElementById('btnLogout');
    if (logoutBtn) {
        logoutBtn.addEventListener('click', function () {
            if (confirm('Are you sure you want to logout?')) {
                // Handle logout logic
                window.location.href = 'Login.aspx';
            }
        });
    }
}

/**
 * Initialize tooltips
 */
function initializeTooltips() {
    // Table capacity tooltip
    const tableCapacities = document.querySelectorAll('.table-capacity');
    tableCapacities.forEach(function (capacity) {
        capacity.setAttribute('title', 'Table Capacity');
    });

    // Payment status tooltip
    const paymentStatuses = document.querySelectorAll('.payment-status');
    paymentStatuses.forEach(function (status) {
        const statusText = status.textContent.trim();
        status.setAttribute('title', 'Payment Status: ' + statusText);
    });
}

/**
 * Show table details
 * @param {string} tableId - Table ID
 */
function showTableDetails(tableId) {
    console.log('Showing details for table: ' + tableId);

    // In a real application, you would fetch table details from the server
    // and show them in a modal or side panel

    // For demo purposes, just show an alert
    alert('Table #' + tableId + ' details would be shown here');
}

/**
 * Open reservation modal
 */
function openModal() {
    const modal = document.getElementById('addReservationModal');
    if (modal) {
        modal.style.display = 'block';

        // Set default date to today
        const dateInput = document.getElementById('txtDate');
        if (dateInput && !dateInput.value) {
            const today = new Date().toISOString().split('T')[0];
            dateInput.value = today;
        }

        // Set default time
        const timeInput = document.getElementById('txtTime');
        if (timeInput && !timeInput.value) {
            timeInput.value = '19:00';
        }

        // Focus on customer name
        const nameInput = document.getElementById('txtCustomerName');
        if (nameInput) {
            setTimeout(() => {
                nameInput.focus();
            }, 300);
        }
    }
}

/**
 * Close reservation modal
 */
function closeModal() {
    const modal = document.getElementById('addReservationModal');
    if (modal) {
        modal.style.display = 'none';
    }
}

/**
 * Animate tables on load
 */
function animateTablesOnLoad() {
    const tables = document.querySelectorAll('.table-item');
    tables.forEach(function (table, index) {
        table.style.opacity = '0';
        setTimeout(function () {
            table.style.opacity = '1';
            table.style.animation = 'fadeIn 0.3s ease forwards';
        }, index * 50);
    });

    const reservations = document.querySelectorAll('.reservation-card');
    reservations.forEach(function (reservation, index) {
        reservation.style.opacity = '0';
        setTimeout(function () {
            reservation.style.opacity = '1';
            reservation.style.animation = 'slideUp 0.3s ease forwards';
        }, index * 100);
    });
}
