public class QALightAboutPage {

    /**
     * Header
     */

    // Выбрал для проверки ссылок с номерами моб.телефонов
    // и ссылки для перехода на страницу входа в личный кабинет

    String tel380637801078 = "//a [@href = 'tel:+380637801078']"; //Ссылка на телефон +380637801078
    String tel380977801078 = "//a [contains(text(), '+38 (097) 78-010-78')]"; //Ссылка на телефон +380977801078
    String tel380997801078 = "//a [contains(text(), '(099)') and contains(text(), '010-78')]"; //Ссылка на телефон +380997801078
    String StudentsOffice = "//a [@class ='reg']";

    // Выбрал для проверки перехода в главное меню
    // и кнопки с выподающим списком и ссылок в нем (для примера сделал только одну кнопку)

    String headerLogo = "//img [@src = 'https://qalight.com.ua/wp-content/themes/qalight/images/logo_qalight.png']"; //Лого QALight
    String aboutUsInDropDown = "//li [@id ='menu-item-254']/a [contains(text(), 'О нас')]"; // Выпадающий список "О нас"
    String aboutUsButtonInDropDown = "//li [@id='menu-item-5447']/a [contains(text(), 'О нас')]"; //Кнопка "О нас" в списке "О нас"
    String QALightIsInDropDown =  "//li [@id='menu-item-433']/a [contains(text(), 'QALight') and contains(text(), 'это')]"; // Ссылка "QALight — это…" в списке "О нас"
    String administrationInDropDown =  "//li [@id='menu-item-5451']/a [contains(text(), 'Администрация')]"; // Ссылка "Администрация" в списке "О нас"
    String ourTrainersInDropDown = "//li [@id='menu-item-432']/a [contains(text(), 'Наши тренеры')]"; // Ссылка "Наши тренеры" в списке "О нас"
    String galleryInDropDown = "//li [@id='menu-item-490']/a [contains(text(), 'Галерея')]"; // Ссылка "Галерея" в списке "О нас"
    String reviewsInDropDown = "//li [@id='menu-item-574']/a [contains(text(), 'Отзывы')]"; // Ссылка "Отзывы" в списке "О нас"

    // Выбрал для проверки поля поиска

    String inputSearch = "//input [@type = 'search']"; // Поле поиска
    String inputButton  = "//input [@alt= 'find']"; // Кнопка поиска

    // Выбрал для проверки "хлебных крошек"

    String BreadcrumbsBlock  = "//div [@class = 'breadcrumbs']"; // Блок с "хлебными крошками"

    /**
     * Блок меню
     */

    //Выблал для проверки ссылок в блоке меню слева

    String aboutUsInBlockMenu = "//li [//li [@id='menu-item-417']/a[contains(text(), 'QALight — это…')]"; // Ссылка "О нас" в меню
    String administrationInBlockMenu =  "//li [@id='menu-item-5456']/a[contains(text(), 'Администрация')]"; // Ссылка "Администрация" в меню
    String ourTrainersInBlockMenu = "//li [@id='menu-item-416']/a[contains(text(), 'Наши тренеры')]"; // Ссылка "Наши тренеры" в меню
    String galleryInBlockMenu = "//li [@id='menu-item-491']/a[contains(text(), 'Галерея')]"; // Ссылка "Галерея" в меню
    String reviewsInBlockMenu = "//li [@id='menu-item-575']/a[contains(text(), 'Отзывы')]"; // Ссылка "Отзывы" в меню

    /**
     * Контент
     */

    //Выблал для проверки контента

    String contentBlock = "//div [@class = 'about-block']";

    /**
     * Footer
     */

    //Выблал для проверки элементов в футере

    String footerLogo = "//div[@class = 'footer clearfix']/div/div/a/img[@alt = 'qalight']";
    String footerIconFacebook = "//span [@class = 'icon facebook']";
    String footerIconLinkedin = "//span [@class = 'icon linkedin']";
    String footerIconYoutube = "//span [@class = 'icon youtube']";
    String footerIconGreenweb = "//img [@alt= 'greenweb']";
}
