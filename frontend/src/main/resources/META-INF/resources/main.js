document.addEventListener('DOMContentLoaded', function onDOMContentLoaded() {
  document.querySelector('button').addEventListener('click', function onButtonClick() {
    fetch('/items')
      .then(response => response.json())
      .then(json => json.map(item => {
        var li = document.createElement('li');
        li.textContent = `${item.content} (${item.id})`;
        return li;
      }))
      .then(listItems => {
        var ul = document.createElement('ul');
        listItems.forEach(li => ul.appendChild(li));
        document.querySelector('.container').replaceWith(ul);
      });
  }, false);
}, false);
