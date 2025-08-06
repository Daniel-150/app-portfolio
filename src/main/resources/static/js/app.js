const hamburgerBtn = document.getElementById('hamburgerBtn');
        const menu = document.getElementById('menu');

        hamburgerBtn.addEventListener('click', function() {
            this.classList.toggle('active');
            menu.classList.toggle('active');
        });
