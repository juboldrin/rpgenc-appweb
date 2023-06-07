function toggleDescription(character) {
    var description = document.getElementById('description-' + character);
    description.style.display = description.style.display === 'block' ? 'none' : 'block';
}