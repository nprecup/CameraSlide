Automated Camera Slider
=================================================

The goal of this project is to create a budget, yet high quality, motorized camera slider, with two axis capability, and Bluetooth communications. This slider is to be used in very remote locations for time-lapse landscape astrophotography. This drives a requirement for portability, with a small battery and low power consumption.

Mechanical Design
-----------------------

The slide axis is made using two aluminum shafts that serve as rails. A low cost ACME lead screw moves the cart along the axis, driven by a low cost Futaba S3003 servo modified for continuous rotation. The controller can be adapted (without modification to the circuit) for other mecahnical drive systems that may be more practical depending on the resources available, including belts or driven rollers. The choice of using hobby servos instead of stepper motors was made clear by the power consumption and complexity requirement. Complex motion profiles are not necessary, and open loop control will work fine. Stepper motors consume too much current, all the time (though the current can be reduced while not moving). Servo motors already have drivers built into them, making it necessary to supply only power and PWM control input. While the open loop control is based upon dead reckoning (timing), rather than by the advantageous simple steps of a stepper motor, the motors can be moved carefully to produce repeatable results. A stepper motor requires additional drive circuitry, increasing cost and complexity.

Circuit Design
-----------------------

This project uses a BlueGiga BLE113 module to control and interface with a motorized camera slide. The BLE113 module contains a 2541 microcontroller that is capable of providing 16-bit resolution PWM output for servo drive signals, hardware interrupt events for limit switches, and timers with GPIO to trigger a camera shutter for time lapse photography. The system is currently being developed for Canon EOS cameras, with an Android app for bluetooth control.

The circuit was designed using Eagle PCB design software. Below is a schematic of the circuit system.

![Alt text](/Circuit/Schematic-V1-June14.png?raw=true "Camaera Slider Circuit")

One update that will need to be included in a future version is moving the PWM output control to P0_6 and P0_7. An oversight occurred, and P0_3 is not useable for PWM control. P0_3 is attached to the 0 timer channel which is used for the baseline frequency only. As such the slide axis control must be set to channel P0_4 (yaw axis connection) for prototyping.

Additional improvements include adding a header to expose the TX/RX connections on UART0 (moving PWM output to Timer1 Alt1 will permit us to use UART0).