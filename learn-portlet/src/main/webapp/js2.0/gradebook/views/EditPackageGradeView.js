/**
 * Package grade edit.
 */

EditPackageGradeView = Backbone.View.extend({
    events: {
        "click .save-package-grade-button": "save"
    },

    initialize: function (options) {
        this.options = options;
        this.$el = jQuery('<div>');
        this.$el.attr("id", this.model.id);
//        this.model.loadGrade({packageId:this.model.id}, {
//            success: jQuery1816Gradebook.proxy(function (res) {
//                this.model.set('grade',res.grade);
//                this.model.set('comment',res.comment);
//                this.render();
//            }, this),
//            error: function (err, res) {
//                // do something in case of an error
//            }
//        });
    },

    render: function () {
        var template = Mustache.to_html(jQuery("#editPackageGradeTemplate").html(), _.extend(this.model.toJSON(), language));
        this.$el.html(template);
        var gradeSelect = this.$('#totalGradeChoice');
        gradeSelect.empty();
        for (var i = 0; i <= 100; i += 10) {
            if (Math.abs(i - this.model.get('grade')) < 10)
                gradeSelect.append('<option selected value=' + i + '>' + i + '%</option>');
            else
                gradeSelect.append('<option value=' + i + '>' + i + '%</option>');
        }
        return this.$el;
    },

    save: function () {
        this.model.set('grade', this.$('#totalGradeChoice :selected').val());
        this.model.set('comment', this.$('#courseComment').val());

        // TODO: save data and trigger to update list
        this.model.saveGrade(
//            {
//            studentId:this.model.get('studentId'),
//            packageId:this.model.id,
//            totalGrade:this.model.get('grade'),
//            gradeComment:this.model.get('comment')
//        }
            {}
            ,{
                success: jQuery1816Gradebook.proxy(function (res) {
                    toastr.success(language['saveCompleted']);
                }, this),
                error: jQuery1816Gradebook.proxy(function (err, res) {
                    toastr.error(language['saveFailed']);
                }, this)
            });
        this.trigger('refreshPackageGrade');
    }
});
