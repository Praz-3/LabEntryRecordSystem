  $(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            u_id: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply u-id'
                    }
                }
            },
             s_name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply name'
                    }
                }
            },
            
            s_class: {
                validators: {
                    notEmpty: {
                        message: 'Please select class'
                    }
                }
            },
            branch: {
                validators: {
                    notEmpty: {
                        message: 'Please select branch'
                    }
                }
            },
            roll_no: {
                validators: {
                    notEmpty: {
                        message: 'Please select class'
                    }
                }
            },
            batch: {
                validators: {
                    notEmpty: {
                        message: 'Please select class'
                    }
                }
            },
            pass: {
                validators: {
                    notEmpty: {
                        message: 'Please enter Password'
                    }
                }
            },
         
            }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

           
        });
});