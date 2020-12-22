var newWordForm = {
    init : function () {
            var _this = this;
            $('#btn_save').on('click', function () {
                _this.save();
            });
        },
    save : function () {
        var data = {
            word: $('#word').val(),
            meaning: $('#meaning').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/words',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('새로운 단어가 등록되었습니다.');
            location.href = "/"
        }).fail(function (error) {
            alert(error);
        });
    }
}
newWordForm.init();