require "securerandom"

if __FILE__ == $0
  begin
    f = File.open("script.txt", "r")
  rescue Errno::ENOENT
    puts "Could not open file"
    exit
  end

  energy_converter_text = f.read
  (0...2).each do |i|
    energy_converter_text.each_char do |c|
      print(c)
      sleep(0.02)
    end 
  end

  count = 0
  
  while true
    SecureRandom.hex.each_char do |c|
      print(c)
      print("\n") if count % 80 == 0
      sleep(0.01)

      count += 1
    end
  end
end
