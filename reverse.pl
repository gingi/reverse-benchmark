#!/usr/bin/env perl

use strict;
use warnings;

use Time::HiRes qw/time/;

use constant INPUT => <<EOF;
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin libero mi,
euismod efficitur laoreet at, elementum et lectus. Curabitur finibus velit vel
egestas vestibulum. Aliquam porta blandit ipsum, quis imperdiet purus ornare
eget. Nullam in lectus nec massa finibus posuere. In molestie ut ipsum tempor
interdum. Nulla accumsan risus ut diam ornare ultricies. Maecenas eu
sollicitudin augue. Proin eu nulla lobortis, sodales dolor et, bibendum nisl.
Integer vitae est ac purus condimentum mollis. Quisque bibendum nunc ac lorem
ultricies, et sagittis nunc fermentum. Nullam tincidunt egestas neque, ac luctus
massa bibendum nec. Nunc tincidunt porta mattis. Fusce eget sem at lacus dapibus
ullamcorper. Vestibulum maximus ligula at justo volutpat semper. Donec tincidunt
quis arcu et interdum. Integer a mauris ut mi fringilla pharetra.
EOF

# Array manipulation
sub reverse1 {
    my ($str) = @_;
    return join("", reverse(split("", $str)));
}

# String concatenation
sub reverse2 {
    my ($str) = @_;
    my $out = "";
    for (my $i = length($str)-1; $i >= 0; $i--) {
        $out .= substr($str, $i-1, 1);
    }
    return $out;
}

MAIN: {
    my $times = +$ARGV[0];
    my $arg   = $ARGV[1];
    my $method = undef;

    $method = $arg eq "1" ? \&reverse1 : \&reverse2;

    my $start = time;
    for (my $i = 0; $i < $times; $i++) {
        $method->(INPUT);
    }
    print time - $start, "\n";
}
