const searchEl = document.querySelector('.search');
const searchInputEl = searchEl.querySelector('input');

searchEl.addEventListener('click', function(){
    // Logic...
    searchInputEl.focus(); 
});

searchInputEl.addEventListener('focus', function(){
    searchEl.classList.add('focused'); 
    searchInputEl.setAttribute('placeholder', '통합검색'); 
}); 
searchInputEl.addEventListener('blur', function(){
    searchEl.classList.remove('focused'); 
    searchInputEl.setAttribute('placeholder', ''); 
}); 


const badgeEl = document.querySelector('header .badges');

window.addEventListener('scroll', _.throttle(function(){
    // console.log('scroll!');
    console.log(window.scrollY);
    if(window.scrollY > 500){
        // 배지 숨기기 
        // badgeEl.style.display = 'none';
        // gsap.to(요소, 지속시간, 옵션); 
        gsap.to(badgeEl, .6, {
            opacity : 0,
            display : 'none'
        })
    }else{
        // 배지 보이기
        // badgeEl.style.display = 'block';
        gsap.to(badgeEl, .6, {
            opacity : 1,
            display : 'block'
        })
    }
}, 300));


const fadeElements = document.querySelectorAll(".visual .fade-in");
fadeElements.forEach(function(fadeElement, index){
    gsap.to(fadeElement, 1, {
        delay : (index + 1) * .7,
        opacity : 1
    });
});



// swiperjs
new Swiper('.notice-line .swiper-container',{
    direction : 'vertical',
    autoplay : true,
    loop : true
});
new Swiper('.promotion .swiper-container', {
    // direction: 'horizontal',
    slidesPerView : 3, //한번에 보여줄 슬라이드 개수
    spaceBetween : 10, // 슬라이드 사이 여백
    centeredSlides : true, // 1번 슬라이드가 가운데 보이기
    loop : true,
    autoplay : {
        delay : 3000
    },
    pagination : {
        el : '.promotion .swiper-pagination', //페이지 번호 요소 선택자
        clickable : true // 사용자의 페이지 번호 요소 제어 가능 여부
    },
    navigation : {
        prevEl : '.promotion .swiper-prev',
        nextEl : '.promotion .swiper-next'
    }
});
